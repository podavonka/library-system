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
@Table(name = "Author")
public class Author {

    @Id
    private Long id;

    private String firstName;

    private String surname;

    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors")
    private Set<PublishingHouse> publishingHouses = new HashSet<>();

    public void addPublishingHouse(PublishingHouse publishingHouse) {
        publishingHouses.add(publishingHouse);
    }
}
