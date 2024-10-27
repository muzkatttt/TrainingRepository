package hwLesson3.entities.heroes;

import hwLesson3.entities.enemies.Enemy;
import hwLesson3.entities.enemies.Mortal;

import java.util.Random;

public class Archer extends Hero implements Mortal {

    private final int MIN_DAMAGE = 5;
    private final int MAX_DAMAGE = 31;

    Random random = new Random();
    int damage = random.nextInt(MIN_DAMAGE, MAX_DAMAGE);
    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int health) {
        super(name, health);
    }

    @Override
    public int attackEnemy(Enemy enemy) {
//        Random random = new Random();
//        int damage = random.nextInt(MIN_DAMAGE, MAX_DAMAGE);
        System.out.printf("%s пошел в атаку! Нанесен урон %d.\n", getName(), damage);
        return enemy.takeDamage(damage);
    }

    @Override
    public int takeDamage(int damage){
        int result = getHealth() - damage;
        System.out.printf("%s получил удар %d, осталось здоровья %d.\n", getName(), damage, result);
        return result;
    }


    @Override
    public boolean isAlive() {
        return super.isAlive();
    }
}
