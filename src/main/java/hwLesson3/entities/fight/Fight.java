package hwLesson3.entities.fight;

import hwLesson3.entities.enemies.Gangster;
import hwLesson3.entities.heroes.Warrior;


public class Fight {

    public void fight(Warrior warrior, Gangster gangster) {

        System.out.println("Игра идет\n");
        while (gangster.isAlive()) {
            warrior.attackEnemy(gangster);
            gangster.setHealth(gangster.getHealth());
            if (gangster.isAlive()) {
                gangster.attackHero(warrior);
                warrior.setHealth(warrior.getHealth());

            } else {
                System.out.println("Game is over");
            }
            break;
        }
    }
}
