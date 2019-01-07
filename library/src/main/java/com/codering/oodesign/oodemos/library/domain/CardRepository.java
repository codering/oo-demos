package com.codering.oodesign.oodemos.library.domain;

public interface CardRepository {

    LibraryCard load(String cardNo);

    void save(LibraryCard card);
}
