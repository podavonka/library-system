package cz.cvut.fel.sin.library.controller;

import cz.cvut.fel.sin.library.dto.DTOMapper;
import cz.cvut.fel.sin.library.dto.LibraryDTO;
import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.entity.Library;
import cz.cvut.fel.sin.library.facade.LibraryFacade;
import cz.cvut.fel.sin.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/libraries")
@RestController
@RequiredArgsConstructor
@Slf4j
public class LibraryController {

    private final LibraryFacade libraryFacade;
    private final LibraryService libraryService;
    private final DTOMapper dtoMapper;

    @GetMapping
    public ResponseEntity<List<LibraryDTO>> findAllLibraries() {
        log.info("LibraryController calls method findAllLibraries");
        return ResponseEntity.ok(libraryService.getLibraries().stream().map(dtoMapper::libraryToLibraryDTO).toList());
    }

    public ResponseEntity<LibraryDTO> addBookToLibrary(Book book, Library library) {
        log.info("LibraryController calls method addBookToLibrary");
        return ResponseEntity.ok(dtoMapper.libraryToLibraryDTO(libraryFacade.addBookToLibrary(book, library)));
    }
}
