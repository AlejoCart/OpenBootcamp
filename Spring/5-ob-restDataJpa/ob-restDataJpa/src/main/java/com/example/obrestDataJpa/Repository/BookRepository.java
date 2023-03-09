package com.example.obrestDataJpa.Repository;

import com.example.obrestDataJpa.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book,Long> {
}
