package com.tech.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.entity.Book;
import com.tech.exception.BookNotFound;
import com.tech.repository.BookRepository;
import com.tech.service.BookServicei;

@Service
public class BookServiceimp implements BookServicei {
	@Autowired
	BookRepository repo;

	@Override
	public String AddBook(Book b) {
		Book save = repo.save(b);

		return "data Save SuccessFully";
	}

	@Override
	public String AddAllBook(List<Book> b) {
     List<Book> saveAll = repo.saveAll(b);
		
		return "All Data Save Successfully";
	}

	@Override
	public List<Book> getBook() {
		List<Book> all = repo.findAll();
		return all;
	}

	@Override
	public Book getBook(long id) {
		Optional<Book> byId = repo.findById(id);

		return byId.orElse(null);
	}

	@Override
	public Book updateBook(long id, Book updatedBook) {
	    // Find the book by ID
	    Optional<Book> byId = repo.findById(id);

	    if (byId.isPresent()) {
	        Book existingBook = byId.get();

	        // Update fields
	        existingBook.setTitle(updatedBook.getTitle());
	        existingBook.setAuthour(updatedBook.getAuthour());
	        existingBook.setIsbn(updatedBook.getIsbn());
	        existingBook.setPublishYear(updatedBook.getPublishYear());
	        existingBook.setAvalableCopy(updatedBook.getAvalableCopy());

	        // Save and return the updated book
	        return repo.save(existingBook);
	    } else {
	        throw new BookNotFound("Book with ID " + id + " not found.");
	    }
	

}

	@Override
	public void deleteBook(long id) {
		
		 if (repo.existsById(id)) {
	            repo.deleteById(id); // Delete the book
	        } else {
	            throw new BookNotFound("Book with ID " + id + " not found.");
	        }
	    }

	}

	


