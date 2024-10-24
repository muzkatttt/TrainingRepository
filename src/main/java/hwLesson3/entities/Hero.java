package hwLesson3.entities;

public abstract class Hero {
    private String name;


    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract int attackEnemy(int damage);
}
