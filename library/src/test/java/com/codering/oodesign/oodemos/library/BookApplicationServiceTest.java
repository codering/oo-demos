package com.codering.oodesign.oodemos.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.codering.oodesign.oodemos.library.command.BorrowBooksCommand;
import com.codering.oodesign.oodemos.library.command.ReturnBooksCommand;
import com.codering.oodesign.oodemos.library.domain.Book;
import com.codering.oodesign.oodemos.library.domain.CardRepository;
import com.codering.oodesign.oodemos.library.domain.LibraryCard;
import com.codering.oodesign.oodemos.library.infra.persistence.CardMapRepository;
import com.codering.oodesign.oodemos.library.infra.common.IdGenerator;

public class BookApplicationServiceTest {

    private BookApplicationService bookApplicationService;
    private String cardNo = "10000";
    private LibraryCard card;
    private CardRepository repository;

    @Before
    public void setUp() throws Exception {
        card = new LibraryCard(cardNo);
        //repository = mock(CardRepository.class);
        //when(repository.load(cardNo)).thenReturn(card);
        repository = new CardMapRepository();
        repository.save(card);
        bookApplicationService = new BookApplicationService(repository);
    }

    @Test
    public void borrowBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(IdGenerator.createId()));
        books.add(new Book(IdGenerator.createId()));
        books.add(new Book(IdGenerator.createId()));

        BorrowBooksCommand command = new BorrowBooksCommand();
        command.setCardNo(cardNo);
        command.setBooks(books);

        bookApplicationService.borrowBooks(command);

        assertEquals(card.getBorrowedBooksCount(), repository.load(cardNo).getBorrowedBooksCount());
    }

    @Test
    public void returnBooks() {
        Book book1 = new Book(IdGenerator.createId());
        Book book2 = new Book(IdGenerator.createId());
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        LibraryCard card = new LibraryCard(cardNo);
        card.addBooks(books);
        repository.save(card);

        ReturnBooksCommand command = new ReturnBooksCommand();
        command.setCardNo(cardNo);
        command.setBooks(Arrays.asList(book1));

        bookApplicationService.returnBooks(command);

        assertEquals(1, repository.load(cardNo).getBorrowedBooksCount());

    }

}
