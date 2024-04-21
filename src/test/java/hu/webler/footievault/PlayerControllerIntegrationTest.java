package hu.webler.footievault;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.webler.footievault.entity.Player;
import hu.webler.footievault.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        playerRepository.deleteAll();
        Player player1 = new Player(null, "Norbert Bálint", 44, "Forward", null);
        Player player2 = new Player(null, "Miska Kis", 29, "Midfielder", null);
        playerRepository.saveAll(Arrays.asList(player1, player2));
    }

    @Test
    public void testGetAllPlayers() throws Exception {
        mockMvc.perform(get("/api/players")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Norbert Bálint"))
                .andExpect(jsonPath("$[1].name").value("Miska Kis"));
    }

    @Test
    public void testCreatePlayer() throws Exception {
        Player newPlayer = new Player(null, "Lajos Kovacs", 30, "Defender", null);
        mockMvc.perform(post("/api/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newPlayer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Lajos Kovacs"));
    }

    @Test
    public void testUpdatePlayer() throws Exception {
        Player existingPlayer = playerRepository.findAll().get(0);
        existingPlayer.setName("Updated Name");

        mockMvc.perform(put("/api/players/" + existingPlayer.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(existingPlayer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }

    @Test
    public void testDeletePlayer() throws Exception {
        Player existingPlayer = playerRepository.findAll().get(0);

        mockMvc.perform(delete("/api/players/" + existingPlayer.getId()))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/players/" + existingPlayer.getId()))
                .andExpect(status().isNotFound());
    }
}
