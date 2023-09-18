package cz.cvut.fel.sin.library.facade;

import cz.cvut.fel.sin.library.entity.Author;
import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.entity.PublishingHouse;
import cz.cvut.fel.sin.library.service.AuthorService;
import cz.cvut.fel.sin.library.service.BookService;
import cz.cvut.fel.sin.library.service.PublishingHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublishingHouseFacade {

    private final PublishingHouseService publishingHouseService;
    private final AuthorService authorService;
    private final BookService bookService;

    public PublishingHouse addAuthorToPublishingHouse(Author author, PublishingHouse publishingHouse) {
        PublishingHouse p = publishingHouseService.addAuthorToPublishingHouse(author, publishingHouse);
        authorService.addPublishingHouseToAuthor(publishingHouse, author);
        return p;
    }

    public PublishingHouse addBookToPublishingHouse(Book book, PublishingHouse publishingHouse) {
        PublishingHouse p = publishingHouseService.addBookToPublishingHouse(book, publishingHouse);
        bookService.createBook(book);
        return p;
    }
}
