package hwLesson3.entities.enemies;

import hwLesson3.entities.heroes.Hero;

import java.util.Random;

public class Gangster extends Enemy {

    private final int MIN_DAMAGE = 1;
    private final int MAX_DAMAGE = 5;


    private final int MIN_HEALH = 0;

    Random random = new Random();
    int damage = random.nextInt(MIN_DAMAGE, MAX_DAMAGE);


    public Gangster(int health) {
        super(health);
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public int takeDamage(int damage) {
        return super.takeDamage(damage);
    }
//    @Override
//    public int takeDamage(int damage) {
//        if (isAlive()) {
//            int result = getHealth() - random.nextInt(MIN_DAMAGE, MAX_DAMAGE);;
//            System.out.printf("Враг получил удар %d, осталось здоровья %d.\n",
//                    random.nextInt(MIN_DAMAGE, MAX_DAMAGE),
//                    result);
//            return result;
//        } else {
//            System.out.println("Враг повержен!");
//            return 0;
//        }
//    }

    @Override
    public boolean isAlive() {
        return getHealth() > MIN_HEALH;
    }
    public int attackHero(Hero hero) {
        int resultOfAttack = hero.getHealth() - damage;
        System.out.printf("%s нанес мне урон %d. Осталось здоровья %s\n", hero.getName(), damage, resultOfAttack);
        return hero.takeDamage(damage);
    }

}
//public int attackEnemy(Enemy enemy) {
//        int resultOfAttack = enemy.getHealth() - damage;
//        System.out.printf("Я пошел в атаку! Нанес урон врагу %d. Осталось здоровья у врага %s\n", damage,
//                resultOfAttack);
//        return resultOfAttack;
//
//    }
