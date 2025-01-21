package ru.aston.hwLesson3.entities.fight;

import ru.aston.hwLesson3.entities.heroes.Warrior;
import ru.aston.hwLesson3.entities.enemies.Gangster;


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
