INSERT INTO address (id, city, postcode, street) VALUES(1, 'a', 'a', 'a');
INSERT INTO address (id, city, postcode, street) VALUES(2, 'b', 'b', 'b');
INSERT INTO address (id, city, postcode, street) VALUES(3, 'c', 'c', 'c');
INSERT INTO address (id, city, postcode, street) VALUES(4, 'd', 'd', 'd');

INSERT INTO library (id, name, address_id) VALUES(1, 'l1', 1);
INSERT INTO library (id, name, address_id) VALUES(2, 'l2', 2);

INSERT INTO publishing_house (id, name, address_id) VALUES(1, 'ph1', 1);
INSERT INTO publishing_house (id, name, address_id) VALUES(2, 'ph2', 3);
INSERT INTO publishing_house (id, name, address_id) VALUES(3, 'ph3', 4);

INSERT INTO book (id, isbn, author, genre, name, publication_date, publishing_house_id) VALUES (1, 'isbnA', 'AuthorA', 'genreA',  'nameA', 'dateA', 1);
INSERT INTO book (id, isbn, author, genre, name, publication_date, publishing_house_id) VALUES (2, 'isbnB', 'AuthorB', 'genreB',  'nameB', 'dateB', 1);
INSERT INTO book (id, isbn, author, genre, name, publication_date, publishing_house_id) VALUES (3, 'isbnC', 'AuthorC', 'genreC',  'nameC', 'dateC', 2);
INSERT INTO book (id, isbn, author, genre, name, publication_date, publishing_house_id) VALUES (4, 'isbnD', 'AuthorD', 'genreD',  'nameD', 'dateD', 1);

