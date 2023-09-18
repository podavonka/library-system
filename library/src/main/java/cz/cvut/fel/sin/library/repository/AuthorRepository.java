package cz.cvut.fel.sin.library.repository;

import cz.cvut.fel.sin.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
