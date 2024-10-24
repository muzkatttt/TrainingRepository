package hwLesson3.entities;

public class Mage extends Hero{
    public Mage(String name) {
        super(name);
    }

    @Override
    public void attackEnemy() {
        System.out.printf("%s пошел в атаку!\n", getName());;
    }
}
