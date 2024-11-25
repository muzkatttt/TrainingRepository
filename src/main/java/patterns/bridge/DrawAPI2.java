package patterns.bridge;


// конкретная реализация для рисования в ASCII
public class DrawAPI2 implements DrawingAPI{
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("API2.circle {" + x + ", " + y + "} radius " + radius);
    }
}
