package hwLesson3.entities;

public class Warrior extends Hero{
    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attackEnemy() {
        System.out.printf("%s очень грозно атакует врагов\n", getName());
    }
}
