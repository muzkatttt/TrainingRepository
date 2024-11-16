package generics.game.weapon;

import generics.game.weapon.MagicWeapon;

public class Wand implements MagicWeapon {
    @Override
    public int getDamage() {
        return 20;
    }
}
