package com.codering.oodesign.oodemos.library.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryCard {

    private String cardNo;

    private List<Book> borrowedBooks;

    public LibraryCard(String cardNo) {
        this.cardNo = cardNo;
        this.borrowedBooks = new ArrayList<>();
    }

    public void addBooks(List<Book> books) {
        borrowedBooks.addAll(books);
    }

    public void removeBooks(List<Book> books) {
        List<Book> leftBooks = new ArrayList<>();
        books.forEach(book -> leftBooks.addAll(
                borrowedBooks.stream()
                        .filter(b -> !b.getBookNo().equals(book.getBookNo()))
                        .collect(Collectors.toList())));
        this.borrowedBooks = leftBooks;
    }

    public int getBorrowedBooksCount() {
        return borrowedBooks.size();
    }

    public String getCardNo() {
        return cardNo;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

}
