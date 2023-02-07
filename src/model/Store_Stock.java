package model;

import jakarta.persistence.Entity;

@Entity
public class Store_Stock {
    Book book;
    int piece;
}
