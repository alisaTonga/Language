package de.ait.language.GroupCards.DTO;

import de.ait.language.wordCards.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseGroup {
    private Long id;
    private String name;
    private List<Card> cards;
}
