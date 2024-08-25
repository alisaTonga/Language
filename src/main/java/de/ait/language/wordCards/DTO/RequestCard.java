package de.ait.language.wordCards.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestCard {
    private String language;
    private String word;
    private String example;
    private String translateLanguage;
    private String translation;
    private String groups;
}
