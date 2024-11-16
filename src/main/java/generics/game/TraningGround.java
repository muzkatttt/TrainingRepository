package generics.game;

import generics.game.enemies.Enemy;
import generics.game.heroes.Archer;
import generics.game.heroes.Hero;
import generics.game.heroes.Mage;
import generics.game.heroes.Warrior;


public class TraningGround {
    public static void main(String[] args) {
        Hero warrior = new Warrior("Боромир", 15);
        Hero mage = new Mage("Гэндольф", 20);
        Hero archer = new Archer("Леголас", 10);

        Enemy enemy = new Enemy("Зомби", 100);

        attackEnemy(enemy, warrior, mage, archer);
    }

    public static void attackEnemy(Enemy enemy, Hero... heroes) {
        while (enemy.isAlive()) {
            for (Hero hero : heroes) {
                if (enemy.isAlive()) {
                    hero.attackEnemy(enemy);
                }
            }
        }

    }
}
