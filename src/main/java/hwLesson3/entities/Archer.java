package hwLesson3.entities;

public class Archer extends Hero{
    public Archer(String name) {
        super(name);
    }

    @Override
    public void attackEnemy() {
        System.out.printf("%s грозно атакует врага!", getName());
    }
}
