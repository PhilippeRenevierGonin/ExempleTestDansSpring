package hello.engine;

import java.util.Random;

/**
 * exemple de classe qui, dans cet exemple, n'est pas un composant (choix de conception, à justifier)
 */
public class Dice {

    private final Random motor;

    public Dice(Random motor) {
        this.motor = motor;
    }

    public int throwDice() {
        return motor.nextInt(6)+1;
    }
}
