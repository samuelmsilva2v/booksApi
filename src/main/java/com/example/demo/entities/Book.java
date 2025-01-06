package com.example.demo.entities;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date publicationDate;
	private String publisher;
	private String collection;
}
