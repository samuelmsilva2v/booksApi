package com.example.demo.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

		var book = bookRepository.findById(id).get();

		book.setId(id);
		book.setTitle(request.getTitle());
		book.setAuthor(request.getAuthor());
		book.setGenre(request.getGenre());
		book.setPublicationDate(request.getPublicationDate());
		book.setPublisher(request.getPublisher());
		book.setCollection(request.getCollection());

		return modelMapper.map(book, BookResponseDto.class);
	}

	@Override
	public String delete(UUID id) {
		
		var book = bookRepository.findById(id).get();
		
		bookRepository.delete(book);
		
		return "Livro excluído com sucesso!";
	}

	@Override
	public BookResponseDto getById(UUID id) {

		var book = bookRepository.findById(id).get();

		return modelMapper.map(book, BookResponseDto.class);
	}

	@Override
	public List<BookResponseDto> getAll() {

		return bookRepository.findAll().stream().map(book -> modelMapper.map(book, BookResponseDto.class))
				.collect(Collectors.toList());
	}

}
