package hwLesson3.entities.fight;

import hwLesson3.entities.enemies.Gangster;
import hwLesson3.entities.heroes.Warrior;


public class Fight {
    private int ROUND = 3;

    public void fight(Warrior warrior, Gangster gangster) {

        System.out.println("Игра идет\n");

        for (int i = 0; i < ROUND; i++) {

            if (warrior.isAlive() && gangster.isAlive()) {
                warrior.attackEnemy(gangster);
                gangster.attackHero(warrior);
                warrior.takeDamage(warrior.getHealth());
                gangster.takeDamage(gangster.getHealth());

            } else {
                System.out.println("Game is over");
            }
        }
    }
}

