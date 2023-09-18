package cz.cvut.fel.sin.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String author;

    private String genre;

    private String ISBN;

    private String name;

    private String publicationDate;
}
