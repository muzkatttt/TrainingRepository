package patterns.bridge;

// конкретная реализация для рисования на графическом окне
public class DrawAPI implements DrawingAPI{
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("API.circle {" + x + ", " + y + "} radius " + radius);
    }
}
