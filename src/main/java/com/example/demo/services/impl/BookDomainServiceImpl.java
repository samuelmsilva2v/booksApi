package com.example.demo.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.BookRequestDto;
import com.example.demo.dtos.BookResponseDto;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.interfaces.BookDomainService;

@Service
public class BookDomainServiceImpl implements BookDomainService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookResponseDto register(BookRequestDto request) {
		// TODO Auto-generated method stub
		return null;
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
