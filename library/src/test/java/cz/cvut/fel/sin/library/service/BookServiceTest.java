package cz.cvut.fel.sin.library.service;

import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.entity.Library;
import cz.cvut.fel.sin.library.repository.BookRepository;
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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;
    @Mock
    private Book book;
    @Mock
    private Library library;

    @BeforeEach
    public void setup(){

    }

    @DisplayName("JUnit test for save method")
    @Test
    public void givenBook_whenSave_thenReturnBook(){
        Mockito.when(bookRepository.save(ArgumentMatchers.any(Book.class))).thenAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) {
                return invocation.getArguments()[0];
            }
        });

        Book bookResult = bookRepository.save(book);

        Assertions.assertNotNull(bookResult);
        Assertions.assertEquals(book, bookResult);
    }

    @DisplayName("JUnit test for getBooks method")
    @Test
    public void givenBooksList_whenGetBooks_thenReturnBooksList(){
        Mockito.when(bookRepository.findAll()).thenReturn(Arrays.asList(book));

        List<Book> bookList = bookService.getBooks();

        Assertions.assertNotNull(bookList);
        Assertions.assertEquals(bookList, Arrays.asList(book));
    }

    @DisplayName("JUnit test for getBookById method")
    @Test
    public void givenBook_whenGetBookById_thenReturnBook(){
        Mockito.when(bookRepository.findById(anyLong())).thenReturn(Optional.of(book));

        Book bookResult = bookService.getBookById(1L);

        Assertions.assertNotNull(bookResult);
        Assertions.assertEquals(bookResult, book);
    }

    @DisplayName("JUnit test for createNewBook method")
    @Test
    public void givenBook_whenCreateNewBook_thenReturnBook(){
        Mockito.when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book bookResult = bookService.save(book);

        Assertions.assertNotNull(bookResult);
        Assertions.assertEquals(bookResult, book);
    }

    @DisplayName("JUnit test for addLibraryToBook method")
    @Test
    public void givenLibraryBook_whenAddLibraryToBook_thenReturnBook(){
        Mockito.when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book bookResult = bookService.addLibraryToBook(library, book);

        Mockito.verify(book).addLibrary(any(Library.class));
        Assertions.assertNotNull(bookResult);
        Assertions.assertEquals(bookResult, book);
    }
}
