package de.ait.language.wordCards.service;

import de.ait.language.wordCards.DTO.RequestCard;
import de.ait.language.wordCards.DTO.ResponseCard;

import java.util.List;

public interface CardService {
    List<ResponseCard> findAll();
    ResponseCard save(RequestCard card);
    List<ResponseCard> getCards
            (String language,String word,String example,String translateLanguage,String translation,String groups);
}
