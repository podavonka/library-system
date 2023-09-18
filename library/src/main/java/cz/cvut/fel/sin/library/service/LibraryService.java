package cz.cvut.fel.sin.library.service;

import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.entity.Library;
import cz.cvut.fel.sin.library.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public List<Library> getLibraries() {
        return libraryRepository.findAll();
    }

    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    public Library addBookToLibrary(Book book, Library library) {
        library.addBook(book);
        return libraryRepository.save(library);
    }
}
