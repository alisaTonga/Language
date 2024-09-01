package de.ait.language.GroupCards.service;

import de.ait.language.GroupCards.DTO.RequestGroup;
import de.ait.language.GroupCards.DTO.ResponseGroup;
import de.ait.language.GroupCards.entity.WordGroup;
import de.ait.language.GroupCards.repository.GroupCardRepository;
import de.ait.language.wordCards.DTO.RequestCard;
import de.ait.language.wordCards.entity.Card;
import de.ait.language.wordCards.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImp implements GroupService {
    private final GroupCardRepository repository;
    private final ModelMapper mapper;
    private final CardRepository cardRepository;

    @Override
    public ResponseGroup save(RequestGroup group) {
        WordGroup wordGroup = mapper.map(group, WordGroup.class);
        WordGroup wordGroup1 = repository.save(wordGroup);
        return mapper.map(wordGroup1, ResponseGroup.class);
    }

//    @Override
//    public ResponseGroup addNewCard(Long groupId, RequestCard dto) {
//        Optional<WordGroup> group = repository.findById(groupId);
//        Card map = mapper.map(dto, Card.class);
//        group.ifPresent(wordGroup -> wordGroup.getCards().add(map));
//        repository.save(group.get());
//        if (group!= null) {
//            return mapper.map(group.get(), ResponseGroup.class);
//        }
//        else {
//            return null;
//        }
//    }

    @Override
    public ResponseGroup deleteCard(Long groupId, Long cardId) {
        repository.findById(groupId).ifPresent(wordGroup -> wordGroup.getCards().remove(cardId));
        return mapper.map(repository.findById(cardId), ResponseGroup.class);
    }

    @Override
    public WordGroup addNewGroup(RequestGroup group) {
        WordGroup group1 = mapper.map(group, WordGroup.class);
        return repository.save(group1);
    }

    @Override
    public void deleteGroup(Long groupId) {
        repository.deleteById(groupId);
    }

    @Override
    public ResponseGroup addNewCard(Long groupId, RequestCard card) {
        repository.findById(groupId).ifPresent(wordGroup -> wordGroup.addCardToList(mapper.map(card, Card.class)));
        return mapper.map(repository.findById(groupId), ResponseGroup.class);
    }

    @Override
    public ResponseGroup addCardToGroup(Long groupId, Long cardId) {
        Optional<Card> card = cardRepository.findById(cardId);
        repository.findById(groupId).ifPresent(wordGroup -> wordGroup.addCardToList(mapper.map(card, Card.class)));
        return mapper.map(repository.findById(groupId), ResponseGroup.class);
    }

    @Override
    public List<WordGroup> findGroups() {
        List<WordGroup> groups = repository.findAll();
        return groups;
    }
}
