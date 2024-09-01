package de.ait.language.GroupCards.controller;
import de.ait.language.GroupCards.DTO.RequestGroup;
import de.ait.language.GroupCards.DTO.ResponseGroup;
import de.ait.language.GroupCards.entity.WordGroup;
import de.ait.language.GroupCards.service.GroupService;
import de.ait.language.wordCards.DTO.RequestCard;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GroupController {
    private GroupService service;
    @GetMapping("groups")
    public List<WordGroup> findAll() {
        return service.findGroups();
    }

    @PostMapping("/groups/{groupId}")
    public ResponseGroup addCardToNewGroup(@PathVariable Long groupId,
                                           @RequestBody RequestCard card) {
        return service.addNewCard(groupId, card);
    }
    @PostMapping("/groups")
    public WordGroup addNewGroup(@RequestBody RequestGroup group) {
        return service.addNewGroup(group);
    }

    @DeleteMapping("groups/{groupId}/{cardId}")
    public void deleteCardFromGroup(@PathVariable Long groupId, @PathVariable Long cardId) {
        service.deleteCard(groupId, cardId);
    }

    @PutMapping("groups/{groupId}/{cardId}")
    public ResponseGroup addCardToGroup(@PathVariable Long groupId, @PathVariable Long cardId) {
        return service.addCardToGroup(groupId, cardId);
    }
}
