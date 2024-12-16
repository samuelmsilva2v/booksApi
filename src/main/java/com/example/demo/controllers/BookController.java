package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.BookRequestDto;
import com.example.demo.dtos.BookResponseDto;
import com.example.demo.services.interfaces.BookDomainService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	private BookDomainService bookDomainService;

	@PostMapping
	public BookResponseDto post(@RequestBody BookRequestDto request) {
		return bookDomainService.register(request);
	}

	@PutMapping("{id}")
	public BookResponseDto put(@PathVariable UUID id, @RequestBody BookRequestDto request) {
		return bookDomainService.update(id, request);
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) {
		// TODO
		return null;
	}

	@GetMapping("{id}")
	public BookResponseDto getById(@PathVariable UUID id) {
		return bookDomainService.getById(id);
	}

	@GetMapping
	public List<BookResponseDto> getAll() {
		return bookDomainService.getAll();
	}

}
