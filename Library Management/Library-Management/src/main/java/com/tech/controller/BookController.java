package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.entity.Book;
import com.tech.exception.BookNotFound;
import com.tech.service.BookServicei;

@RestController
@RequestMapping("/add")
public class BookController {
	@Autowired
	BookServicei si;
	@PostMapping("/AddBook")
	public ResponseEntity<String>AddBook(@RequestBody Book b)
	{
//		b.setBookId((long) 10);
		String addBook = si.AddBook(b);
		
		return new ResponseEntity<String>(addBook,HttpStatus.CREATED);
	
	}
	
	@PostMapping("/AddAll")
	public ResponseEntity<String>AddAllData(@RequestBody List<Book>bk)
	{
		String Resp = si.AddAllBook(bk);
		return new ResponseEntity<String>(Resp,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/GetBook")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = si.getBook();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

	@GetMapping("/GetBookId/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Book book = si.getBook(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
        	throw new BookNotFound("this Book id Is Not Avalable" + id );
        }
//        throw new BookNotFoundException("Book with ID " + id + " not found.");

	}
	@PutMapping("/Update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book updatedBook) {
	    try {
	        Book book = si.updateBook(id, updatedBook);
	        return new ResponseEntity<>(book, HttpStatus.OK);
	    } catch (BookNotFound ex) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@DeleteMapping("/Delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        try {
            si.deleteBook(id); // Call the service to delete the book
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 No Content
        } catch (BookNotFound ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 Not Found
        }
    }

}