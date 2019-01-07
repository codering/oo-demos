package com.codering.oodesign.oodemos.library.infra.persistence;

import java.util.HashMap;
import java.util.Map;

import com.codering.oodesign.oodemos.library.domain.CardRepository;
import com.codering.oodesign.oodemos.library.domain.LibraryCard;

public class CardMapRepository implements CardRepository {

    private static final Map<String, LibraryCard> DB = new HashMap<>();

    @Override
    public LibraryCard load(String cardNo) {
        return DB.get(cardNo);
    }

    @Override
    public void save(LibraryCard card) {
        DB.put(card.getCardNo(), card);
    }

}
