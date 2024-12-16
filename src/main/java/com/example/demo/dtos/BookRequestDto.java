package com.example.demo.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookRequestDto {

	private String title;
	private String author;
	private String genre;
	private LocalDate publicationDate;
	private String publisher;
	private String collection;
}
