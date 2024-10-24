package hwLesson3.entities;

public class Enemy implements Mortal{
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
        int result = getHealth() - damage;
        System.out.printf("Враг получил удар %d, осталось здоровья %d.\n", damage, result);
        return result;
    }

    @Override
    public boolean isAlive() {
        return getHealth()> MIN_HEALTH;
    }

}
