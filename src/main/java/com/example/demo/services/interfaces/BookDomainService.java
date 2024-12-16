package com.example.demo.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.dtos.BookRequestDto;
import com.example.demo.dtos.BookResponseDto;

public interface BookDomainService {

	public BookResponseDto register(BookRequestDto request);
	
	public BookResponseDto update(UUID id, BookRequestDto request);
	
	public String delete(UUID id);
	
	public BookResponseDto getById(UUID id);
	
	public List<BookResponseDto> getAll();
}
