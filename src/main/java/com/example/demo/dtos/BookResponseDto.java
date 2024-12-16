package com.example.demo.dtos;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BookResponseDto {

	private UUID id;
	private String title;
	private String author;
	private String genre;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate publicationDate;
	private String publisher;
	private String collection;
}
