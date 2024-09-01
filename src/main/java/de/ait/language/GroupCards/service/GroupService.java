package de.ait.language.GroupCards.service;

import de.ait.language.GroupCards.DTO.RequestGroup;
import de.ait.language.GroupCards.DTO.ResponseGroup;
import de.ait.language.GroupCards.entity.WordGroup;
import de.ait.language.wordCards.DTO.RequestCard;
import de.ait.language.wordCards.DTO.ResponseCard;

import java.util.List;

public interface GroupService {
    ResponseGroup save(RequestGroup group);
    ResponseGroup addNewCard(Long groupId, RequestCard card);
    ResponseGroup deleteCard(Long groupId, Long cardId);
    WordGroup addNewGroup(RequestGroup group);
    void deleteGroup(Long groupId);
    ResponseGroup addCardToGroup(Long groupId, Long cardId);
    List<WordGroup> findGroups();

}
