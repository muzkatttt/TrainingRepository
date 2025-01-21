package ru.aston.hwLesson3;

import ru.aston.hwLesson3.entities.fight.Fight;
import ru.aston.hwLesson3.entities.heroes.Warrior;
import ru.aston.hwLesson3.entities.enemies.Gangster;

public class TrainingGround {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Warrior", 30);
        Gangster gangster = new Gangster(30);
        Fight fight = new Fight();
        fight.fight(warrior, gangster);

    }

}
