package com.example.demo.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BookRequestDto {

	private String title;
	private String author;
	private String genre;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date publicationDate;
	private String publisher;
	private String collection;
}
