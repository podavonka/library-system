package cz.cvut.fel.sin.library.repository;

import cz.cvut.fel.sin.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
