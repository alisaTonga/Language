package de.ait.language.GroupCards.DTO;

import de.ait.language.wordCards.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class RequestGroup {
    private String name;
    private List<Card> cards;

    public RequestGroup(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }
}
