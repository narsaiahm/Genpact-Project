package com.example.library.controler;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.exception.BookServiceException;
import com.example.library.model.Book;
import com.example.library.service.BookServiceImpl;
/**
 * 
 * @author narsaiah
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BookController {

	private static final Logger logger = LogManager.getLogger(BookController.class);
	
	@Autowired
	BookServiceImpl bookService;
	
	/**
	 * 
	 * @return ResponseEntity<List<Book>>
	 * @throws BookServiceException 
	 */
	@RequestMapping(value = "/getBooks", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Book>> getBooks() throws BookServiceException {
		logger.info("Caling getBooks() method.");
		List<Book> booksList = bookService.findAllBooks();
		logger.debug("Getting books List and List :",booksList);
		return ResponseEntity.ok().body(booksList);
	
	}
	/**
	 * 
	 * @param bookId
	 * @return ResponseEntity<Book>
	 * @throws BookServiceException 
	 */
	 @RequestMapping(value = "/getBookInfo/{bookId}", method = RequestMethod.GET, produces = "application/json")
	  public ResponseEntity<Book> getBookingDetails(@PathVariable Long bookId) throws BookServiceException {
		 logger.info("Caling getBookingDetails() method.");
		 Book bookInfo = bookService.getBookInfoByBookId(bookId);
		 logger.info("Getting book info for the bookId :"+bookId+" and response:", bookInfo);
		 return ResponseEntity.ok().body(bookInfo);
	  	  
	  }
	
	 /**
	  * 
	  * @param books
	 * @throws BookServiceException 
	  */
	@RequestMapping(value = "/addBook", method = RequestMethod.POST, produces = "application/json")
		public void addBooks(@RequestBody List<Book> books) throws BookServiceException {
		 logger.info("Caling getBookingDetails() method.");
		 bookService.addNewBook(books);

	}
	/**
	 * 
	 * @param books
	 * @return ResponseEntity<String>
	 * @throws BookServiceException 
	 */
	@RequestMapping(value = "/upateBook", method = RequestMethod.POST, produces = "application/json")
	public void upateBook(@RequestBody List<Book> books) throws BookServiceException {
		 logger.info("Caling upateBook() method.");
		bookService.updateBookDetails(books);
		 logger.debug("Update the books list successffully");
		}
	/**
	 * 
	 * @param bookId
	 * @return ResponseEntity<String>
	 * @throws BookServiceException 
	 */
	@RequestMapping(value = "/delBook/{bookId}", method = RequestMethod.POST, produces = "application/json")
	public void delBooks(@PathVariable Long bookId) throws BookServiceException {
		logger.info("Caling delBooks() method with bookId :",bookId);
		bookService.deleteBookById(bookId);
		logger.debug("Delted the book with the id " +bookId+" successffully");
		}


}
