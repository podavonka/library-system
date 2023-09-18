package cz.cvut.fel.sin.library.repository;

import cz.cvut.fel.sin.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
