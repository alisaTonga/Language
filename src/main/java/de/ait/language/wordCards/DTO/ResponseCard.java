package de.ait.language.wordCards.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCard {
    private Long id;
    private String language;
    private String word;
    private String example;
    private String translateLanguage;
    private String translation;
    private String groups;
}
