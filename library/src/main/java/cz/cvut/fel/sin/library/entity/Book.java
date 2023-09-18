package cz.cvut.fel.sin.library.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class Book {

    @Id
    private Long id;

    private String author;

    private String genre;

    private String ISBN;

    private String name;

    private String publicationDate;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private Set<Library> libraries = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="publishing_house_id", nullable=false)
    private PublishingHouse publishingHouse;

    public void addLibrary(Library library) {
        libraries.add(library);
    }
}
