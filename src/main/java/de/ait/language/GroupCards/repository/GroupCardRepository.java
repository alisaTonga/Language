package de.ait.language.GroupCards.repository;

import de.ait.language.GroupCards.entity.WordGroup;
import de.ait.language.wordCards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupCardRepository extends JpaRepository<WordGroup, Long> {
}
