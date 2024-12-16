package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
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
		request.setPublicationDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000"));
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
		fail("Not Implemented");
	}

	@Test
	@Order(3)
	void updateBookTest() throws Exception {
		fail("Not Implemented");
	}

	@Test
	@Order(4)
	void consultBooksTest() throws Exception {
		fail("Not Implemented");
	}

	@Test
	@Order(5)
	void deleteBookTest() throws Exception {
		fail("Not Implemented");
	}

}
