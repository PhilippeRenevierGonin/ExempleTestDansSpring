package hello.engine;


import hello.player.Player;
import hello.utils.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GameSpringWithMockBeanTest {

    @MockBean
    HelloController mockedLogger;


    @MockBean
    Player p1;

    @Mock
    Player p2;

    @Mock
    Player p3;

    @Autowired
    Game testedGame;

    @Test
    void addPlayerTest() {
        // dans ce test, p1 pourrait être un mock standard
        testedGame.addPlayers(p1);
        verify(mockedLogger, times(1)).log(anyString());
        verify(p1, times(1)).addObjective(any());
    }


    @Test
    void add2PlayersTest() {
        // dans ce test, p1 pourrait être un mock standard -> la preuve p2 en est un
        testedGame.addPlayers(p1, p2);
        verify(mockedLogger, times(2)).log(anyString());
        verify(p1, times(1)).addObjective(any());
        verify(p2, times(1)).addObjective(any());
    }

    @Test
    void add2PlayersTestWith2StandardMocks() {
        // dans ce test, p3 et p2 en sont deux mocks standards
        testedGame.addPlayers(p3, p2);
        verify(mockedLogger, times(2)).log(anyString());
        verify(p3, times(1)).addObjective(any());
        verify(p2, times(1)).addObjective(any());
    }

    @Test
    void addAutomaticallylayersTest() {
        // dans ce tests, p1 est un @MockBean : on ne peut le définir qu'une fois...
        testedGame.addAutomaticallyPlayers();
        verify(mockedLogger, times(2)).log(anyString());
        verify(p1, times(2)).addObjective(any());
    }

}
