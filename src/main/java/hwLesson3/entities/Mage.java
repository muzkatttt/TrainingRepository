package hwLesson3.entities;


import java.util.Random;

public class Mage extends Hero{

    private final int MIN_DAMAGE = 1;
    private final int MAX_DAMAGE = 15;
    public Mage(String name) {
        super(name);
    }

    public int attackEnemy(Enemy enemy) {
        Random random = new Random();
        int damage = random.nextInt(MIN_DAMAGE, MAX_DAMAGE);
        System.out.printf("%s пошел в атаку! Нанесен урон %d.\n", getName(), damage);
        return enemy.takeDamage(damage);
    }
}
