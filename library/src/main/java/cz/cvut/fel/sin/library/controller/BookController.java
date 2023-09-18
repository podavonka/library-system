package cz.cvut.fel.sin.library.controller;

import cz.cvut.fel.sin.library.dto.BookDTO;
import cz.cvut.fel.sin.library.dto.DTOMapper;
import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Secured("ROLE_ADMIN")
@RequestMapping("/books")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;
    private final DTOMapper dtoMapper;

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAllBooks() {
        log.info("BookController calls method findAllBooks");
        return ResponseEntity.ok(bookService.getBooks().stream().map(dtoMapper::bookToBookDTO).toList());
    }

    @GetMapping(value = "/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("bookId") Long bookId) {
        log.info("BookController calls method getBookById");
        return ResponseEntity.ok(dtoMapper.bookToBookDTO(bookService.getBookById(bookId)));
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> insertBook(@RequestBody Book book) {
        log.info("BookController calls method insertBook");
        return ResponseEntity.ok(dtoMapper.bookToBookDTO(bookService.save(book)));
    }
}
