package com.example.library.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.library.exception.BookServiceException;
import com.example.library.model.Book;

public interface BookService {
	public List<Book> findAllBooks() throws BookServiceException ;
	public Book getBookInfoByBookId(long bookId)throws BookServiceException;
	public void addNewBook(List<Book> books)throws BookServiceException;
	public void updateBookDetails(List<Book> books) throws BookServiceException;
	public void deleteBookById(Long bookId) throws BookServiceException;
}
