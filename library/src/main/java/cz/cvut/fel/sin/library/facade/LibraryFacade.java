package cz.cvut.fel.sin.library.facade;

import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.entity.Library;
import cz.cvut.fel.sin.library.service.BookService;
import cz.cvut.fel.sin.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LibraryFacade {

    private final LibraryService libraryService;
    private final BookService bookService;

    public Library addBookToLibrary(Book book, Library library) {
        Library l = libraryService.addBookToLibrary(book, library);
        bookService.addLibraryToBook(library, book);
        return l;
    }
}
