package com.example.demo.services.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.BookRequestDto;
import com.example.demo.dtos.BookResponseDto;
import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.interfaces.BookDomainService;

@Service
public class BookDomainServiceImpl implements BookDomainService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BookResponseDto register(BookRequestDto request) {
		
		var book = modelMapper.map(request, Book.class);
		book.setId(UUID.randomUUID());
		
		bookRepository.save(book);
		
		return modelMapper.map(book, BookResponseDto.class);
	}

	@Override
	public BookResponseDto update(UUID id, BookRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookResponseDto getById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookResponseDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
