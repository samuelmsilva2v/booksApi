package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

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

@RestController
@RequestMapping("/api/books")
public class BookController {

	@PostMapping
	public BookResponseDto post(@RequestBody BookRequestDto request) {
		// TODO
		return null;
	}

	@PutMapping("{id}")
	public BookResponseDto put(@PathVariable UUID id, @RequestBody BookRequestDto request) {
		// TODO
		return null;
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) {
		// TODO
		return null;
	}

	@GetMapping("{id}")
	public BookResponseDto getById(@PathVariable UUID id) {
		// TODO
		return null;
	}

	@GetMapping
	public List<BookResponseDto> getAll() {
		// TODO
		return null;
	}

}
