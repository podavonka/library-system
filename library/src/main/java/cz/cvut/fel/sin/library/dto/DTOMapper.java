package cz.cvut.fel.sin.library.dto;

import cz.cvut.fel.sin.library.entity.Author;
import cz.cvut.fel.sin.library.entity.Book;
import cz.cvut.fel.sin.library.entity.Library;
import cz.cvut.fel.sin.library.entity.PublishingHouse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    BookDTO bookToBookDTO(Book book);

    AuthorDTO authorToAuthorDTO(Author author);

    LibraryDTO libraryToLibraryDTO(Library library);

    PublishingHouseDTO publishingHouseToPublishingHouseDTO(PublishingHouse publishingHouse);
}
