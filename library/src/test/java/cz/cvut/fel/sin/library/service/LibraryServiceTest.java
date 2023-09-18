package cz.cvut.fel.sin.library.service;

import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.entity.Library;
import cz.cvut.fel.sin.library.repository.LibraryRepository;
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

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {
    @Mock
    private LibraryRepository libraryRepository;
    @InjectMocks
    private LibraryService libraryService;
    @Mock
    private Library library;
    @Mock
    private Book book;

    @BeforeEach
    public void setup(){

    }

    @DisplayName("JUnit test for save method")
    @Test
    public void givenLibrary_whenSave_thenReturnLibrary(){
        Mockito.when(libraryRepository.save(ArgumentMatchers.any(Library.class))).thenAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) {
                return invocation.getArguments()[0];
            }
        });

        Library libraryResult = libraryService.save(library);

        Assertions.assertNotNull(libraryResult);
        Assertions.assertEquals(libraryResult, libraryResult);
    }

    @DisplayName("JUnit test for getLibraries method")
    @Test
    public void givenLibrariesList_whenGetLibraries_thenReturnLibrariesList(){
        Mockito.when(libraryRepository.findAll()).thenReturn(List.of(library));

        List<Library> libraryList = libraryService.getLibraries();

        Assertions.assertNotNull(libraryList);
        Assertions.assertEquals(libraryList, List.of(library));
    }

    @DisplayName("JUnit test for addBookToLibrary method")
    @Test
    public void givenBookLibrary_whenAddBookToLibrary_thenReturnLibrary(){
        Mockito.when(libraryRepository.save(any(Library.class))).thenReturn(library);

        Library libraryResult = libraryService.addBookToLibrary(book, library);

        Mockito.verify(library).addBook(any(Book.class));
        Assertions.assertNotNull(libraryResult);
        Assertions.assertEquals(libraryResult, library);
    }
}
