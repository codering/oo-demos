package com.codering.oodesign.oodemos.library;

import com.codering.oodesign.oodemos.library.command.BorrowBooksCommand;
import com.codering.oodesign.oodemos.library.command.ReturnBooksCommand;
import com.codering.oodesign.oodemos.library.domain.CardRepository;
import com.codering.oodesign.oodemos.library.domain.LibraryCard;

public class BookApplicationService {

    private CardRepository repository;

    public BookApplicationService(CardRepository repository) {
        this.repository = repository;
    }

    public void borrowBooks(BorrowBooksCommand command) {
        LibraryCard card = repository.load(command.getCardNo());
        card.addBooks(command.getBooks());
        repository.save(card);
    }

    public void returnBooks(ReturnBooksCommand command) {
        LibraryCard card = repository.load(command.getCardNo());
        card.removeBooks(command.getBooks());
        repository.save(card);
    }
}
