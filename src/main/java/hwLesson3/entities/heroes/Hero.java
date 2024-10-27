package hwLesson3.entities.heroes;

import hwLesson3.entities.enemies.Enemy;
import hwLesson3.entities.enemies.Mortal;

public abstract class Hero implements Mortal {
    private final String name;
    private int health;

    private int damage;


    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int attackEnemy(Enemy enemy){
        return enemy.takeDamage(this.damage);
    }


    public int takeDamage(int damage){
        return getHealth() - damage;
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
