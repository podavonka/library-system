package cz.cvut.fel.sin.library.service;

import cz.cvut.fel.sin.library.entity.Author;
import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.entity.PublishingHouse;
import cz.cvut.fel.sin.library.repository.PublishingHouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublishingHouseService {

    private final PublishingHouseRepository publishingHouseRepository;

    @Cacheable("publishingHouse")
    public List<PublishingHouse> getPublishingHouses() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return publishingHouseRepository.findAll();
    }

    public PublishingHouse save(PublishingHouse publishingHouse) {
        return publishingHouseRepository.save(publishingHouse);
    }

    public PublishingHouse addAuthorToPublishingHouse(Author author, PublishingHouse publishingHouse) {
        publishingHouse.addAuthor(author);
        return publishingHouseRepository.save(publishingHouse);
    }

    public PublishingHouse addBookToPublishingHouse(Book book, PublishingHouse publishingHouse) {
        publishingHouse.addBook(book);
        return publishingHouseRepository.save(publishingHouse);
    }
}
