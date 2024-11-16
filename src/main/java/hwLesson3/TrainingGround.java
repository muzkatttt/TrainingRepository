package hwLesson3;

import hwLesson3.entities.enemies.Gangster;
import hwLesson3.entities.fight.Fight;
import hwLesson3.entities.heroes.Warrior;

public class TrainingGround {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Warrior", 30);
        Gangster gangster = new Gangster(30);
        Fight fight = new Fight();
        fight.fight(warrior, gangster);

    }

}
