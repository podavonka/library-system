package cz.cvut.fel.sin.library.service;

import cz.cvut.fel.sin.library.entity.Author;
import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.entity.PublishingHouse;
import cz.cvut.fel.sin.library.repository.PublishingHouseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PublishingHouseServiceTest {
    @Mock
    private PublishingHouseRepository publishingHouseRepository;
    @InjectMocks
    private PublishingHouseService publishingHouseService;
    @Mock
    private PublishingHouse publishingHouse;
    @Mock
    private Book book;
    @Mock
    private Author author;

    @BeforeEach
    public void setup(){

    }

    @DisplayName("JUnit test for getPublishingHouses method")
    @Test
    public void givenPublishingHousesList_whenPublishingHouses_thenReturnPublishingHousesList(){
        Mockito.when(publishingHouseRepository.findAll()).thenReturn(List.of(publishingHouse));

        List<PublishingHouse> publishingHouseList = publishingHouseService.getPublishingHouses();

        Assertions.assertNotNull(publishingHouseList);
        Assertions.assertEquals(publishingHouseList, List.of(publishingHouse));
    }

    @DisplayName("JUnit test for addBookToPublishingHouse method")
    @Test
    public void givenBookPublishingHouse_whenAddBookToPublishingHouse_thenReturnPublishingHouse(){
        Mockito.when(publishingHouseRepository.save(any(PublishingHouse.class))).thenReturn(publishingHouse);

        PublishingHouse publishingHouseResult = publishingHouseService.addBookToPublishingHouse(book, publishingHouse);

        Mockito.verify(publishingHouse).addBook(any(Book.class));
        Assertions.assertNotNull(publishingHouseResult);
        Assertions.assertEquals(publishingHouseResult, publishingHouse);
    }

    @DisplayName("JUnit test for addAuthorToPublishingHouse method")
    @Test
    public void givenAuthorPublishingHouse_whenAddAuthorToPublishingHouse_thenReturnPublishingHouse(){
        Mockito.when(publishingHouseRepository.save(any(PublishingHouse.class))).thenReturn(publishingHouse);

        PublishingHouse publishingHouseResult = publishingHouseService.addAuthorToPublishingHouse(author, publishingHouse);

        Mockito.verify(publishingHouse).addAuthor(any(Author.class));
        Assertions.assertNotNull(publishingHouseResult);
        Assertions.assertEquals(publishingHouseResult, publishingHouse);
    }
}
