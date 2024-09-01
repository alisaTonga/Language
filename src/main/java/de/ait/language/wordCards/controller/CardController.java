package de.ait.language.wordCards.controller;

import de.ait.language.wordCards.DTO.RequestCard;
import de.ait.language.wordCards.DTO.ResponseCard;
import de.ait.language.wordCards.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CardController {
    private final CardService service;
    @PostMapping("/cards")
    public ResponseCard addCard(@RequestBody RequestCard dto){
        return service.save(dto);
    }
    @GetMapping("/cards")
    public List<ResponseCard> getCards(
            @RequestParam (name = "l", required = false, defaultValue = "") String language,
            @RequestParam (name = "w", required = false, defaultValue = "") String word,
            @RequestParam (name = "e", required = false, defaultValue = "") String example,
            @RequestParam (name = "tl", required = false, defaultValue = "") String translateLanguage,
            @RequestParam (name = "t", required = false, defaultValue = "") String translation
//            @RequestParam (name = "g", required = false, defaultValue = "") String groups
    ){
    return service.getCards(language,word,example,translateLanguage,translation);
    }
}
