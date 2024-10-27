package hwLesson3.entities.enemies;


public class Zombie extends Enemy {
    public Zombie(int health) {
        super(health);
    }

    @Override
    public int takeDamage(int damage) {
        return super.takeDamage(damage);
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }
}
