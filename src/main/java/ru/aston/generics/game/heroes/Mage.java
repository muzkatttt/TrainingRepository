package ru.aston.generics.game.heroes;

import ru.aston.generics.game.enemies.Enemy;
import ru.aston.generics.game.weapon.MagicWeapon;

public class Mage<T extends MagicWeapon> extends Hero<T>{
    public Mage(String name, int damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " сотворил заклинание на " + enemy.getName());
        enemy.takeDamage(getDamage());
    }
}
