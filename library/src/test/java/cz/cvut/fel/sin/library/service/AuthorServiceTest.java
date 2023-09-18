package cz.cvut.fel.sin.library.service;

import cz.cvut.fel.sin.library.entity.Author;
import cz.cvut.fel.sin.library.entity.PublishingHouse;
import cz.cvut.fel.sin.library.repository.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private PublishingHouse publishingHouse;
    @InjectMocks
    private AuthorService authorService;
    private Author author;

    @BeforeEach
    public void setup(){
        author = author.builder()
                .id(1L)
                .email("email")
                .surname("surname")
                .firstName("firstname")
                .publishingHouses(new HashSet<>())
                .books(new HashSet<>())
                .build();
    }

    @DisplayName("JUnit test for getAuthors method")
    @Test
    public void givenAuthorsList_whenGetAuthors_thenReturnAuthorsList(){
        Mockito.when(authorRepository.findAll()).thenReturn(List.of(author));

        List<Author> authorsList = authorService.getAuthors();

        Assertions.assertNotNull(authorsList);
        Assertions.assertEquals(authorsList, List.of(author));
    }

    @DisplayName("JUnit test for addPublishingHouseToAuthor method")
    @Test
    public void givenPublishingHouseAuthor_whenAddPublishingHouseToAuthor_thenReturnAuthor(){
        Mockito.when(authorRepository.save(ArgumentMatchers.any(Author.class))).thenAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) {
                return invocation.getArguments()[0];
            }
        });

        authorService.addPublishingHouseToAuthor(publishingHouse, author);

        Assertions.assertEquals(List.copyOf(author.getPublishingHouses()), List.of(publishingHouse));
    }
}
