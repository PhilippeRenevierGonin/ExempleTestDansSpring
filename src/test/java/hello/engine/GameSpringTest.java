package hello.engine;

import hello.utils.HelloController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test SpringBoot (lancement de l'application) et JUnit
 * équivalent de test instrumenté android
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class GameSpringTest {



    Game game;
    HelloController logger;

    // on récupère les beans ici ou en attribut avec @Autowired
    @BeforeEach
    void setUp(@Autowired Game g, @Autowired HelloController logger) {
        // se sera l'instance de l'application...
        // l'application est lancée
        this.game = g;
        this.logger = logger;
        logger.mute(); // se répercute aussi sur les autres tests !
    }

    @AfterEach
    void tearDown() {
        // logger.unmute(); // impact sur GameSpringWithMockTest
    }

    @Test
    void getWinner() {
        assertNull(game.getWinner(), "il n'y a pas de gagnant");
    }
}