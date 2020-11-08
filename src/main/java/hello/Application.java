package hello;

import hello.engine.Dice;
import hello.player.AnotherStrategy;
import hello.engine.Game;
import hello.player.Player;
import hello.player.Strategy;
import hello.utils.HelloController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("on entre dans main "+args.length);
        int n = 1;
        if (args.length >0) {
           if (args[0].equals("many")) { n = 3; }
           for(int i = 0; i < n; i++) SpringApplication.run(Application.class, args);
        }

    }

    @Autowired
    private HelloController logger;



    @Bean
    public CommandLineRunner testBean() {
        return args -> {
            System.out.println("***********************************************************************");
            System.out.println("***********************************************************************");
            System.out.println("***********************************************************************");
        };
    }

    @Bean
    public CommandLineRunner aGame(@Autowired Game g, @Autowired Player p1, @Autowired Player p2, @Autowired Strategy s1, @Autowired Strategy s2) {
        return args -> {
            System.out.println("************************** aGame **************************************");

            // pour faire la différence entre un lancement via les tests et un lancement par mvn exec:java@id
            if (args.length >0) {
                logger.index();
                aTurn(g, p1, p2, s1, s2);
            }
        };
    }

    private void aTurn( Game g,  Player p1,  Player p2,  Strategy s1,  Strategy s2) {
        logger.log("running one game ++++++++++++++++++++++++++++++++++ " + g);

        p1.setStrategy(s1);
        p2.setStrategy(s2);
        g.addPlayers(p1, p2);

        Dice d = new Dice(new Random());
        p1.addToScore(p1.plays(d));
        p2.addToScore(p2.plays(d));

        logger.log("and the winner is : " + g.getWinner());
    }


}