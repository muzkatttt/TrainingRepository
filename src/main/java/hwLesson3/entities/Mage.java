package hwLesson3.entities;


public class Mage extends Hero{

    private final int DAMAGE = 10;
    public Mage(String name) {
        super(name);
    }

    @Override
    public int attackEnemy(int health) {
        int result = health - DAMAGE;
        System.out.printf("%s пошел в атаку!\nНанесен урон %d\nОсталось здоровья %d\n", getName(), DAMAGE, result);
        return result;
    }
}
