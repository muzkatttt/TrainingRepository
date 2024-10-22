package hwLesson3.entities;

public class Hero {
    String name;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void attackEnemy(){
        System.out.printf("%s атакует врага!", getName());
    }
}
