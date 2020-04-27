package com.example.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "bookId")
  private Long bookId;
  @Column(name = "title")
  private String title;
  @Column(name = "cover")
  private String cover;
  @Column(name = "publisher")
  private String publisher;
  @Column(name = "pages")
  private int pages;
  @Column(name = "available")
  private int available;
  @Column(name = "createdDate")
  private Date createdDate = new Date();
  @Column(name = "updatedDate")
  private Date updatedDate;
  
  
  public Book() {
	  super();
  }
public Book(Long bookId, String title, String cover, String publisher, int pages, int available, Date createdDate,Date updatedDate) {
	super();
	this.bookId = bookId;
	this.title = title;
	this.cover = cover;
	this.publisher = publisher;
	this.pages = pages;
	this.available = available;
	this.createdDate = createdDate;
	this.updatedDate = updatedDate;
}
public Long getBookId() {
	return bookId;
}
public void setBookId(Long bookId) {
	this.bookId = bookId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCover() {
	return cover;
}
public void setCover(String cover) {
	this.cover = cover;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public int getPages() {
	return pages;
}
public void setPages(int pages) {
	this.pages = pages;
}
public int getAvailable() {
	return available;
}
public void setAvailable(int available) {
	this.available = available;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}
public Date getUpdatedDate() {
	return updatedDate;
}
public void setUpdatedDate(Date updatedDate) {
	this.updatedDate = updatedDate;
}


  

 

}
