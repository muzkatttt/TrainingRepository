package hwLesson3.entities;

public class Gangster extends Enemy{
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

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }
}
