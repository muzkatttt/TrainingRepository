package hwLesson3.entities.heroes;

import hwLesson3.entities.enemies.Enemy;
import hwLesson3.entities.enemies.Mortal;


import java.util.Random;

public class Warrior extends Hero implements Mortal {

    private final int MIN_DAMAGE = 10;
    private final int MAX_DAMAGE = 31;
    Random random = new Random();
    int damage = random.nextInt(MIN_DAMAGE, MAX_DAMAGE);

    private final int MIN_HEALH = 0;


    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, int health) {
        super(name, health);
    }

    @Override
    public int attackEnemy(Enemy enemy) {
        int resultOfAttack = enemy.getHealth() - damage;
        System.out.printf("Я пошел в атаку! Нанес урон врагу %d. Осталось здоровья у врага %s\n", damage,
                resultOfAttack);
        return resultOfAttack;

    }

//    public int takeDamage() {
//        if (isAlive()) {
//            int result = getHealth() - damage;
//            System.out.printf("Я получил удар %d, осталось здоровья %d.\n", damage, result);
//            return result;
//        } else {
//            System.out.printf("%s повержен!", getName());
//            return 0;
//        }
//    }

    @Override
    public int takeDamage(int damage) {
        if (isAlive()) {
            return super.takeDamage(damage);
        } else {
            System.out.println("Здоровье закончилось");
            return MIN_HEALH;
        }
    }

    @Override
    public boolean isAlive() {
        return getHealth() > MIN_HEALH;
    }
}
