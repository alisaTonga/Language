package de.ait.language.wordCards.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "language")
    private String language;
    @Column(name = "word")
    private String word;
    @Column(name = "example")
    private String example;
    @Column(name = "translateLanguage")
    private String translateLanguage;
    @Column(name = "translation")
    private String translation;
    @Column(name = "groups")
    private String groups;
}
