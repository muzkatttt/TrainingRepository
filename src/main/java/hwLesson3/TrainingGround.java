package hwLesson3;

import hwLesson3.entities.Archer;
import hwLesson3.entities.Hero;
import hwLesson3.entities.Mage;
import hwLesson3.entities.Warrior;

public class TrainingGround {
    public static void main(String[] args) {

//        Hero hero = new Hero("Добрыня Никитич");
//        hero.attackEnemy(10);

        Mage mage = new Mage("Маг");
        mage.attackEnemy(100);

        Warrior warrior = new Warrior("Воин");
        warrior.attackEnemy(100);

        Archer archer = new Archer("Лучник");
        archer.attackEnemy(200);

    }
}
