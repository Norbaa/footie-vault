package hu.webler.footievault.repository;

import hu.webler.footievault.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
