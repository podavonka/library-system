package cz.cvut.fel.sin.library.controller;

import cz.cvut.fel.sin.library.dto.DTOMapper;
import cz.cvut.fel.sin.library.dto.PublishingHouseDTO;
import cz.cvut.fel.sin.library.entity.Author;
import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.entity.PublishingHouse;
import cz.cvut.fel.sin.library.facade.PublishingHouseFacade;
import cz.cvut.fel.sin.library.service.PublishingHouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/publishing_houses")
@RestController
@RequiredArgsConstructor
@Slf4j
public class PublishingHouseController {

    private final PublishingHouseFacade publishingHouseFacade;
    private final PublishingHouseService publishingHouseService;
    private final DTOMapper dtoMapper;

    @GetMapping
    public ResponseEntity<List<PublishingHouseDTO>> findAllPublishingHouses() {
        log.info("PublishingHouseController calls method findAllPublishingHouses");
        return ResponseEntity.ok(publishingHouseService.getPublishingHouses().stream().map(dtoMapper::publishingHouseToPublishingHouseDTO).toList());
    }

    @PostMapping
    public ResponseEntity<PublishingHouseDTO> insertPublishingHouse(@RequestBody PublishingHouse publishingHouse) {
        log.info("PublishingHouseController calls method insertPublishingHouse");
        return ResponseEntity.ok(dtoMapper.publishingHouseToPublishingHouseDTO(publishingHouseService.save(publishingHouse)));
    }

    public ResponseEntity<PublishingHouseDTO> concludeAgreementWithAuthor(Author author, PublishingHouse publishingHouse) {
        log.info("PublishingHouseController calls method concludeAgreementWithAuthor");
        return ResponseEntity.ok(dtoMapper.publishingHouseToPublishingHouseDTO(publishingHouseFacade.addAuthorToPublishingHouse(author, publishingHouse)));
    }

    public ResponseEntity<PublishingHouseDTO> publishBook(Book book, PublishingHouse publishingHouse) {
        log.info("PublishingHouseController calls method publishBook");
        return ResponseEntity.ok(dtoMapper.publishingHouseToPublishingHouseDTO(publishingHouseFacade.addBookToPublishingHouse(book, publishingHouse)));
    }
}
