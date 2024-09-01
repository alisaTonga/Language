package de.ait.language.wordCards.service;

import de.ait.language.wordCards.DTO.RequestCard;
import de.ait.language.wordCards.DTO.ResponseCard;
import de.ait.language.wordCards.entity.Card;
import de.ait.language.wordCards.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CardServiceImp implements CardService{
    private final CardRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<ResponseCard> findAll() {
        return repository.findAll().stream()
                .map(c-> mapper.map(c, ResponseCard.class))
                .toList();
    }

    @Override
    public ResponseCard save(RequestCard dto) {
        Card card = mapper.map(dto, Card.class);
        Card newCard = repository.save(card);
        return mapper.map(newCard, ResponseCard.class);
    }

    @Override
    public List<ResponseCard> getCards
            (String language, String word, String example, String translateLanguage, String translation) {
        List<Card> cardList = repository.findAll();

        Predicate<Card> predicateByLanguage = (language == null || language.isEmpty())
                ? card -> true
                : card -> card.getLanguage().toLowerCase().contains(language.toLowerCase());

        Predicate<Card> predicateByWord = (word == null || word.isEmpty())
                ? card -> true
                : card -> card.getWord().equalsIgnoreCase(word);

        Predicate<Card> predicateByExample = (example == null || example.isEmpty())
                ? card -> true
                : card -> card.getExample().equalsIgnoreCase(example);

        Predicate<Card> predicateByTranslateLanguage = (translateLanguage == null || translateLanguage.isEmpty())
                ? card -> true
                : card -> card.getTranslateLanguage().toLowerCase().contains(translateLanguage.toLowerCase());

        Predicate<Card> predicateByTranslation = (translation == null || translation.isEmpty())
                ? card -> true
                : card -> card.getTranslation().toLowerCase().contains(translation.toLowerCase());

//        Predicate<Card> predicateByGroups = (groups == null || groups.isEmpty())
//                ? card -> true
//                : card -> card.getGroups().toLowerCase().contains(groups.toLowerCase());

        Predicate<Card> allCondition =
                predicateByLanguage.and(predicateByWord)
                        .and(predicateByLanguage)
                        .and(predicateByWord)
                        .and(predicateByExample)
                        .and(predicateByTranslateLanguage)
                        .and(predicateByTranslation);
//                        .and(predicateByGroups);

        List<Card> filteredCard = cardList.stream()
                .filter(allCondition)
                .toList();
        List<ResponseCard> responseFilteredCards = filteredCard.stream()
                .map(card -> mapper.map(card, ResponseCard.class))
                .collect(Collectors.toList());
        return responseFilteredCards;
    }
}
