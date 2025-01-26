package com.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Books")
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)

	private Long bookId;
	private String title;
	private String authour;
	private String isbn;
	private String publishYear;
	private String avalableCopy;
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
	public String getAuthour() {
		return authour;
	}
	public void setAuthour(String authour) {
		this.authour = authour;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}
	public String getAvalableCopy() {
		return avalableCopy;
	}
	public void setAvalableCopy(String avalableCopy) {
		this.avalableCopy = avalableCopy;
	}
	public Book(Long bookId, String title, String authour, String isbn, String publishYear, String avalableCopy) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.authour = authour;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.avalableCopy = avalableCopy;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	 

}
