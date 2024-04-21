package hu.webler.footievault.service;

import hu.webler.footievault.entity.Match;
import hu.webler.footievault.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> findAll() {
        return matchRepository.findAll();
    }

    public Optional<Match> findById(Long id) {
        return matchRepository.findById(id);
    }

    public Match save(Match match) {
        return matchRepository.save(match);
    }

    public void delete(Long id) {
        matchRepository.deleteById(id);
    }
}
