package de.ait.language.wordCards.repository;

import de.ait.language.wordCards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
