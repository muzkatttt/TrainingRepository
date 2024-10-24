package hwLesson3.entities;

public class Hero {
    private String name;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void attackEnemy(int damage){
        System.out.printf("%s атакует врага!\n", getName());
    }
}
