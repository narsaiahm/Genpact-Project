package com.example.library.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.library.exception.BookServiceException;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

/**
 * 
 * @author narsaiah
 *
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
	private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

	public static final String NO_RESOURCE = "No resource found for the request ";

	@Autowired
	BookRepository bookRepository;

	/**
	 * Return the list of the existing books from DB.
	 * 
	 * @return List<Book
	 */
	@Override
	public List<Book> findAllBooks() throws BookServiceException {
		List<Book> li = new ArrayList<Book>();
		try {

			bookRepository.findAll().forEach(li::add);

			li.stream().sorted(Comparator.comparing(Book::getCreatedDate)).collect(Collectors.toList());
			logger.debug("Exited from the findAllBooks () method.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BookServiceException(e);
		}
		if (CollectionUtils.isEmpty(li)) {
			throw new ResourceNotFoundException(NO_RESOURCE);
		}
		return li;
	}

	/**
	 * Return the existing book info from DB.
	 * 
	 * @param bookId
	 * @return Book
	 */
	@Override
	public Book getBookInfoByBookId(long bookId) throws BookServiceException {
		Book book;
		try {
			Optional<Book> bookInfo = bookRepository.findById(bookId);
			book = bookInfo.get();
			logger.debug("Exited from the getBookInfoByBookId() method.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BookServiceException(e);
		}
		if (null == book) {
			throw new ResourceNotFoundException(NO_RESOURCE);
		}
		return book;
	}

	/**
	 * Add new book info to the db.
	 * 
	 * @param books
	 */
	@Override
	public void addNewBook(List<Book> books) throws BookServiceException {
		try {
			bookRepository.saveAll(books);
			logger.debug("Exited from the addNewBook() method.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BookServiceException(e);
		}
	}

	/**
	 * Update the existing book info in the DB.
	 * 
	 * @param books
	 */
	@Override
	public void updateBookDetails(List<Book> books) throws BookServiceException {
		Book obj = null;
		try {
			if (null != books && books.size() > 0) {
				obj = books.get(0);
			}
			Optional<Book> updatedBook = bookRepository.findById(Long.valueOf(obj.getBookId()));
			updatedBook.get().setAvailable(obj.getAvailable());
			updatedBook.get().setCover(obj.getCover());
			updatedBook.get().setPages(obj.getPages());
			updatedBook.get().setPublisher(obj.getPublisher());
			updatedBook.get().setTitle(obj.getTitle());
			updatedBook.get().setUpdatedDate(new Date(System.currentTimeMillis()));

			bookRepository.save(updatedBook.get());
			logger.debug("Exited from the updateBookDetails() method.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BookServiceException(e);
		}

	}

	/**
	 * Delete the existing book from DB.
	 * 
	 * @param bookId
	 */
	@Override
	public void deleteBookById(Long bookId) throws BookServiceException {
		try {
			bookRepository.deleteById(bookId);
			logger.debug("Exited from the deleteBookById() method.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BookServiceException(e);
		}
	}

}
