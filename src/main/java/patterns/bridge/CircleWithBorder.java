package patterns.bridge;

// конкретная абстракция
public class CircleWithBorder extends Circle{
    private double x, y, radius; // параметры круга

    public CircleWithBorder(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI); // здесь передаем реализацию в абстракцию
        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    @Override
    public void draw() {
        // используем реализацию для рисования
        drawingAPI.drawCircle(x, y, radius);
    }

    @Override
    public void resizeByPercentage(double pct) {
        radius *= (1 + pct /100); // изменяем размер круга
    }
}
