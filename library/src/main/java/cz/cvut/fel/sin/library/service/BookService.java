package cz.cvut.fel.sin.library.service;

import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.entity.Library;
import cz.cvut.fel.sin.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> result = bookRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            log.warn("THERE IS NO BOOK WITH ID = " + id);
            throw new ResourceNotFoundException("Book " + id);
        }
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book addLibraryToBook(Library library, Book book) {
        book.addLibrary(library);
        return bookRepository.save(book);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
