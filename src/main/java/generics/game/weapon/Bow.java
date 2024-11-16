package generics.game.weapon;

import generics.game.weapon.RangeWeapon;

public class Bow implements RangeWeapon {
    @Override
    public int getDamage() {
        return 10;
    }
}
