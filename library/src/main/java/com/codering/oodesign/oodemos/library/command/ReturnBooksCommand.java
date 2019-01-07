package com.codering.oodesign.oodemos.library.command;

import java.util.List;

import com.codering.oodesign.oodemos.library.domain.Book;

public class ReturnBooksCommand {

    private String cardNo;
    private List<Book> books;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
