package de.ait.language.GroupCards.entity;

import de.ait.language.wordCards.entity.Card;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "WordGroup")
@Builder
@ToString
public class WordGroup {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @Column (name = "name")
    private String name;
    @ManyToMany
    private List<Card> cards;

    public List<Card> addCardToList(Card card) {
        cards.add(card);
        return cards;
    }
}
