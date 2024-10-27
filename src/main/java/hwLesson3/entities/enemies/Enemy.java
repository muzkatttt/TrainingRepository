package hwLesson3.entities.enemies;

public abstract class Enemy implements Mortal {
    private int health;

    private int MIN_HEALTH = 0;


    public Enemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public int takeDamage(int damage){
        return getHealth() - damage;
    }

    @Override
    public boolean isAlive() {
        return getHealth()> MIN_HEALTH;
    }

}
