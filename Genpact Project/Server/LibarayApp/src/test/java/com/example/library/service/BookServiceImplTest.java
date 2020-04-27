package com.example.library.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.library.exception.BookServiceException;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BookServiceImplTest {
	@Mock
	private BookServiceImpl bookService;
		
	@Test
	public void getBooks() throws BookServiceException {
		List<Book> list = new ArrayList<>();
		when(bookService.findAllBooks()).thenReturn( list);
		List<Book> responseEntity = bookService.findAllBooks();
		assertNotNull(responseEntity);
		}
	
	@Test
	public void getBookingDetails() throws BookServiceException {
			Long bookId = 1l;
			Book book = new Book();
			when(bookService.getBookInfoByBookId(bookId)).thenReturn( book);
			Book bookObj = bookService.getBookInfoByBookId(bookId);
			assertNotNull(bookObj);
		 
	}


}
