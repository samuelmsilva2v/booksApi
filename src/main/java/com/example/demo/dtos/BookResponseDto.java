package com.example.demo.dtos;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class BookResponseDto {

	private UUID id;
	private String title;
	private String author;
	private String genre;
	private LocalDate publicationDate;
	private String publisher;
	private String collection;
}
