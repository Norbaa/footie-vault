package hu.webler.footievault;

import hu.webler.footievault.entity.Player;
import hu.webler.footievault.repository.PlayerRepository;
import hu.webler.footievault.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceUnitTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    public void testSavePlayer() {
        Player player = new Player(1L, "Norbert Bálint", 44, "Center", null);
        when(playerRepository.save(any(Player.class))).thenReturn(player);

        Player savedPlayer = playerService.save(player);

        assertNotNull(savedPlayer);
        assertEquals("Norbert Bálint", savedPlayer.getName());
    }

    @Test
    public void testFindByIdFound() {
        Player player = new Player(1L, "Norbert Bálint", 44, "Center", null);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));

        Optional<Player> foundPlayer = playerService.findById(1L);

        assertTrue(foundPlayer.isPresent());
        assertEquals("Norbert Bálint", foundPlayer.get().getName());
    }

    @Test
    public void testFindByIdNotFound() {
        when(playerRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Player> foundPlayer = playerService.findById(1L);

        assertFalse(foundPlayer.isPresent());
    }

    @Test
    public void testDeletePlayer() {
        lenient().when(playerRepository.findById(1L)).thenReturn(Optional.of(new Player(1L, "Norbert Bálint", 44, "Center", null)));

        playerService.delete(1L);

        verify(playerRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testFindAllPlayers() {
        Player player1 = new Player(1L, "Norbert Bálint", 44, "Center", null);
        Player player2 = new Player(2L, "Kis Pista", 30, "Back", null);
        when(playerRepository.findAll()).thenReturn(Arrays.asList(player1, player2));

        List<Player> players = playerService.findAll();

        assertNotNull(players);
        assertEquals(2, players.size());
        assertEquals("Norbert Bálint", players.get(0).getName());
        assertEquals("Kis Pista", players.get(1).getName());
    }
}
