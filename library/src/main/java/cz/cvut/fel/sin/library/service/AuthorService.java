package cz.cvut.fel.sin.library.service;

import cz.cvut.fel.sin.library.entity.Author;
import cz.cvut.fel.sin.library.entity.PublishingHouse;
import cz.cvut.fel.sin.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author addPublishingHouseToAuthor(PublishingHouse publishingHouse, Author author) {
        author.addPublishingHouse(publishingHouse);
        return authorRepository.save(author);
    }
}
