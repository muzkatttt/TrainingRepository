package hwLesson3.entities;

import java.util.Random;

public class Warrior extends Hero{

    private int damage;
    private int MIN_DAMAGE = 10;
    private int MAX_DAMAGE = 31;

    public Warrior(String name) {
        super(name);
    }

    @Override
    public int attackEnemy(int health) {
        Random random = new Random();
        damage = random.nextInt(MIN_DAMAGE, MAX_DAMAGE);
        int result = health - damage;
        System.out.printf("%s пошел в атаку!\nНанесен урон %d\nОсталось здоровья %d\n", getName(), damage, result);
        return result;
    }
}
