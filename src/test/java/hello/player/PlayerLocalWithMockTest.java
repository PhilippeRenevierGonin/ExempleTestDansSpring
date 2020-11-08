package hello.player;

import hello.engine.Dice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * test junit5+mockito
 * (test local)
 * possible car il n'y a pas d'autowired dans Player
 */
@ExtendWith(MockitoExtension.class)
class PlayerLocalWithMockTest {


    @Mock
    Random random;

    Player player;
    Dice dice;

    @BeforeEach
    void setUp() {
        // se sera l'instance de l'application...
        // l'application est lancée
        this.player = new Player();
        this.dice = new Dice(random);
        when(random.nextInt(6)).thenReturn(2);
        when(random.nextInt(6)).thenReturn(2, 3);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getWinner() {
        int result = player.plays(dice);
        assertEquals(3, result, "il devrait jouer 3");
        player.addToScore(result);
        assertEquals(3, player.getScore(), "il devrait avoir 3 pts");
         result = player.plays(dice);
        assertEquals(4, result, "il devrait jouer 3");
    }
}