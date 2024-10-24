package hwLesson3.entities;

public class Enemy {
    private int health;
    private int DAMAGE = 10;

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
        return health - damage;
    }


}
