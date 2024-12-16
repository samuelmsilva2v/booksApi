package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dtos.BookRequestDto;
import com.example.demo.dtos.BookResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BooksApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private static UUID id;

	@Test
	@Order(1)
	void registerBookTest() throws Exception {

		var faker = new Faker(Locale.forLanguageTag("pt-BR"));

		var request = new BookRequestDto();
		request.setTitle(faker.book().title());
		request.setAuthor(faker.book().author());
		request.setGenre(faker.book().genre());
		request.setPublicationDate(LocalDate.of(2000, 1, 1));
		request.setPublisher(faker.book().publisher());
		request.setCollection(faker.book().title());

		var result = mockMvc.perform(
				post("/api/books").contentType("application/json").content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk()).andReturn();

		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		var response = objectMapper.readValue(content, BookResponseDto.class);

		assertNotNull(response.getId());
		assertEquals(response.getTitle(), request.getTitle());
		assertEquals(response.getAuthor(), request.getAuthor());
		assertEquals(response.getGenre(), request.getGenre());
		assertEquals(response.getPublisher(), request.getPublisher());
		assertEquals(response.getCollection(), request.getCollection());

		id = response.getId();
	}

	@Test
	@Order(2)
	void searchBookByIdTest() throws Exception {

		var result = mockMvc.perform(get("/api/books/" + id)).andExpect(status().isOk()).andReturn();

		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		var response = objectMapper.readValue(content, BookResponseDto.class);

		assertEquals(response.getId(), id);
		assertNotNull(response.getTitle());
		assertNotNull(response.getAuthor());
		assertNotNull(response.getGenre());
		assertNotNull(response.getPublicationDate());
		assertNotNull(response.getPublisher());
		assertNotNull(response.getCollection());
	}

	@Test
	@Order(3)
	void updateBookTest() throws Exception {

		var faker = new Faker(Locale.forLanguageTag("pt-BR"));

		var request = new BookRequestDto();
		request.setTitle(faker.book().title());
		request.setAuthor(faker.book().author());
		request.setGenre(faker.book().genre());
		request.setPublicationDate(LocalDate.of(2000, 1, 1));
		request.setPublisher(faker.book().publisher());
		request.setCollection(faker.book().title());

		var result = mockMvc.perform(put("/api/books/" + id).contentType("application/json")
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk()).andReturn();

		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		var response = objectMapper.readValue(content, BookResponseDto.class);

		assertEquals(response.getId(), id);
		assertEquals(response.getTitle(), request.getTitle());
		assertEquals(response.getAuthor(), request.getAuthor());
		assertEquals(response.getGenre(), request.getGenre());
		assertEquals(response.getPublisher(), request.getPublisher());
		assertEquals(response.getCollection(), request.getCollection());
	}

	@Test
	@Order(4)
	void consultBooksTest() throws Exception {

		var result = mockMvc.perform(get("/api/books")).andExpect(status().isOk()).andReturn();

		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		var response = objectMapper.readValue(content, new TypeReference<List<BookResponseDto>>() {
		});

		response.stream().filter(book -> book.getId().equals(id)).findFirst();
	}

	@Test
	@Order(5)
	void deleteBookTest() throws Exception {
		fail("Not Implemented");
	}

}
