package com.tech.service;

import java.util.List;

import com.tech.entity.Book;

public interface BookServicei {

	public String AddBook(Book b);

	public String AddAllBook(List<Book> b);

	public List<Book> getBook();

	public Book getBook(long id);

	public Book updateBook(long id, Book updatedBook);

	public void deleteBook(long id);

}
