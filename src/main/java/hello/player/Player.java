package hello.player;

import hello.engine.Dice;
import hello.engine.Objective;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Player {

    int score = 0;
    private List<Objective> objectiveList = new ArrayList<>();

    public void setStrategy(Strategy s) {
        System.out.println("for me "+this+" setting strategy "+s);
    }

    public int getScore() {
        return score;
    }

    public int plays(Dice dice) {
        return dice.throwDice();
    }

    public int addToScore(int pts) {
        this.score += pts;
        return getScore();
    }

    public void addObjective(Objective objective) {
        this.objectiveList.add(objective);
    }
}
