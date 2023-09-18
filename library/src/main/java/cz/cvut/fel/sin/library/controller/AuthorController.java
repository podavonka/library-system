package cz.cvut.fel.sin.library.controller;

import cz.cvut.fel.sin.library.dto.AuthorDTO;
import cz.cvut.fel.sin.library.dto.DTOMapper;
import cz.cvut.fel.sin.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/authors")
@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthorController {

    private final AuthorService authorService;
    private final DTOMapper dtoMapper;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> findAllAuthors() {
        log.info("AuthorController calls method findAllAuthors");
        return ResponseEntity.ok(authorService.getAuthors().stream().map(dtoMapper::authorToAuthorDTO).toList());
    }
}
