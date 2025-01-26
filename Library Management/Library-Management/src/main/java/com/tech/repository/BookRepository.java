package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
