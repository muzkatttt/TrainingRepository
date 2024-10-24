package hwLesson3;

import hwLesson3.entities.*;

public class TrainingGround {
    public static void main(String[] args) {

//        Hero hero = new Hero("Добрыня Никитич");
//        hero.attackEnemy(10);

        Enemy enemy = new Enemy(100);

        Mage mage = new Mage("Маг");
        mage.attackEnemy(enemy);

        Warrior warrior = new Warrior("Воин");
        warrior.attackEnemy(enemy);

        Archer archer = new Archer("Лучник");
        archer.attackEnemy(enemy);



    }
}
