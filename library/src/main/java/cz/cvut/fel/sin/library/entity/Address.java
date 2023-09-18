package cz.cvut.fel.sin.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

    @Id
    private Long id;

    private String city;

    private String street;

    private String postcode;

    @OneToOne(mappedBy = "address")
    private Library library;

    @OneToOne(mappedBy = "address")
    private PublishingHouse publishingHouse;
}
