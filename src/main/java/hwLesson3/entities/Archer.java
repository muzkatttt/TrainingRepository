package hwLesson3.entities;

import java.util.Random;

public class Archer extends Hero{

    private final int MIN_DAMAGE = 5;
    private final int MAX_DAMAGE = 21;
    public Archer(String name) {
        super(name);
    }

    @Override
    public int attackEnemy(Enemy enemy) {
        Random random = new Random();
        int damage = random.nextInt(MIN_DAMAGE, MAX_DAMAGE);
        System.out.printf("%s пошел в атаку! Нанесен урон %d.\n", getName(), damage);
        return enemy.takeDamage(damage);
    }
}
