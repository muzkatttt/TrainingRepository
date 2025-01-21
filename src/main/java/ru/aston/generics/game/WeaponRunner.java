package ru.aston.generics.game;

import ru.aston.generics.game.heroes.Archer;
import ru.aston.generics.game.heroes.Hero;
import ru.aston.generics.game.heroes.Warrior;
import ru.aston.generics.game.weapon.Bow;
import ru.aston.generics.game.weapon.Sword;

public class WeaponRunner {
    public static void main(String[] args) {
        Archer<Bow> archer = new Archer<Bow>("Лучник", 15);
        archer.setWeapon(new Bow());

        Warrior<Sword> warrior = new Warrior<Sword>("Рыцарь", 10);
        warrior.setWeapon(new Sword());
        printWeaponDamage(warrior);
    }

    // параметризация на уровне метода после сигнатуры метода
//    public static <T extends Weapon> void printWeaponDamage(Hero<T> hero){
//        System.out.println(hero.getWeapon().getDamage());
//    }


    //<? extends Weapon> - по верхнему уровню - потомки
    //<? super Weapon> - по нижнему уровню - предки
    public static void printWeaponDamage(Hero<? extends Sword> hero){
        Sword weapon = hero.getWeapon();
        System.out.println(hero.getWeapon().getDamage());
        System.out.println(weapon);
    }
}


