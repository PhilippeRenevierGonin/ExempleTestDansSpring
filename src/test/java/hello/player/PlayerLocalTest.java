package hello.player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * test juint5 standard, y compris sur un component
 * test qualifiable de "local" (selon la terminologie android)
 * possible car pas d'Autowired dans Player
 */
class PlayerLocalTest {



    Player player;

    @BeforeEach
    void setUp() {
        // se sera l'instance de l'application...
        // l'application est lancée
        this.player = new Player();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getScore() {
        assertEquals(0, player.getScore(), "il devrait avoir 0 pts par défaut");
        player.addToScore(42);
        assertEquals(42, player.getScore(), "il devrait avoir 42 pts");
        player.addToScore(42);
        assertEquals(84, player.getScore(), "il devrait avoir 84 pts");

    }
}