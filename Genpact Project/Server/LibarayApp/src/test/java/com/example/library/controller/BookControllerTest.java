package com.example.library.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.example.library.controler.BookController;
import com.example.library.exception.BookServiceException;
import com.example.library.model.Book;
import com.example.library.service.BookServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BookControllerTest {

	@Mock
	private BookServiceImpl bookService;
	@InjectMocks
	private BookController bookController;

	public MockMvc mockMvc;
	
	@Before(value = "")
	public void setup() {
		MockitoAnnotations.initMocks(this);
		}
	
	@Test
	public void getBooks() throws BookServiceException {
		List<Book> list = new ArrayList<>();
		ResponseEntity<List<Book>> responseEntity = bookController.getBooks();
		assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(list,responseEntity.getBody());
        
		}
	
	@Test
	public void getBookingDetails() throws BookServiceException {
			Long bookId = 1l;
			ResponseEntity<Book> responseEntity = bookController.getBookingDetails(bookId);
			assertNotNull(responseEntity);
	        assertEquals(200, responseEntity.getStatusCodeValue());
	   	 
	}

	/*
	 * @Test public void deleteBook() throws BookServiceException { Long bookId =
	 * 1l; String responseString= bookController.delBooks(bookId);
	 * assertNotNull(responseString);
	 * assertEquals("Book With ID : 1 Deleted Successfully", responseString); }
	 */
	
}
