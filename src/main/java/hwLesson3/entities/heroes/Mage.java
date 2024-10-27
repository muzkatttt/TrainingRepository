package hwLesson3.entities.heroes;


import hwLesson3.entities.enemies.Enemy;

import java.util.Random;

public class Mage extends Hero{

    private final int MIN_DAMAGE = 1;
    private final int MAX_DAMAGE = 15;
    public Mage(String name) {
        super(name);
    }

    public Mage(String name, int health) {
        super(name, health);
    }

    public int attackEnemy(Enemy enemy) {
        Random random = new Random();
        int damage = random.nextInt(MIN_DAMAGE, MAX_DAMAGE);
        System.out.printf("%s пошел в атаку! Нанесен урон %d.\n", getName(), damage);
        return enemy.takeDamage(damage);
    }
    public int takeDamage(int damage){
        int result = getHealth() - damage;
        System.out.printf("%s получил удар %d, осталось здоровья %d.\n", getName(), damage, result);
        return result;
    }
}
