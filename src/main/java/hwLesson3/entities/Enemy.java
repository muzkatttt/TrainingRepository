package hwLesson3.entities;

public class Enemy {
    private int health;

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


}
