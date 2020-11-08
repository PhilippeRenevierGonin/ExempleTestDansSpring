package hello.engine;

import hello.player.Player;
import hello.utils.HelloController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

@Component
@Scope("prototype")

public class Game {
    LinkedHashSet<Player> players = new LinkedHashSet<>();

    @Autowired
    HelloController logger;

    public void addPlayers(Player... allP) {
        for (Player p : allP) {
            logger.log("adding : " + p+" to "+this);
            players.add(p);
            p.addObjective(new Objective());
        }
    }


    /*
    pour illustrer un test avec des @MockBean
     */
    @Autowired Player p1;
    @Autowired Player p2;
     public void addAutomaticallyPlayers() {
        addPlayers(p1, p2);
     }


     public Player  getWinner() {
         logger.log("winner for "+this);
         int winnerPts = 0;
         Player winner = null;
         for(Player p : players) {
             if (p.getScore() > winnerPts) {
                 winner = p;
                 winnerPts = p.getScore();
             }
         }

         return winner;
        }

}
