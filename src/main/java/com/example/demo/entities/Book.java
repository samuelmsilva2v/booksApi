package com.example.demo.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data	
public class Book {

	@Id
	private UUID id;
	private String title;
	private String author;
	private String genre;
	private LocalDate publicationDate;
	private String publisher;
	private String collection;
}
