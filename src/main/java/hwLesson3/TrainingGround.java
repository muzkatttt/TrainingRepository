package hwLesson3;

import hwLesson3.entities.Hero;
import hwLesson3.entities.Mage;
import hwLesson3.entities.Warrior;

public class TrainingGround {
    public static void main(String[] args) {

        Hero hero = new Hero("Добрыня Никитич");
        hero.attackEnemy();

        Mage mage = new Mage("Маг");
        mage.attackEnemy();

        Warrior warrior = new Warrior("Змей Горыныч");
        warrior.attackEnemy();
    }
}
