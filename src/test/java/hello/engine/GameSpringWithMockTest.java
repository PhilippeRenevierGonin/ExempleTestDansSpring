package hello.engine;

import hello.engine.Game;
import hello.player.Player;
import hello.utils.HelloController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;




/**
 * test SpringBoot (lancement de l'application) et JUnit et MOCKITO
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class GameSpringWithMockTest {


    @Mock
    Player p;

    @Mock
    Player p1;


    Game game;

    @BeforeEach
    void setUp(@Autowired Game g, @Autowired HelloController logger) {
        // se sera l'instance de l'application...
        this.game = g;
        when(p.getScore()).thenReturn(10);
        when(p1.getScore()).thenReturn(9);
        // System.out.println(logger.index());
        // logger.mute();
    }


    @Test
    void getWinner() {
        assertNull(game.getWinner(), "il n'y a pas de gagnant");
        game.addPlayers(p, p1);
        assertEquals(p,game.getWinner(),"10 > 9, p gagne");
    }

    @Test
    void addPlayer() {
        game.addPlayers(p, p1);
        assertEquals(p,game.getWinner(),"10 > 9, p gagne");
    }
}