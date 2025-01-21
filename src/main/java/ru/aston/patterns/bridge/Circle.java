package ru.aston.patterns.bridge;

public abstract class Circle {
    protected DrawingAPI drawingAPI;
    // ссылка на реализацию

    protected Circle(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    // метод для рисования
    public abstract void draw();

    // метод для изменения азмера
    public abstract void resizeByPercentage(double pct);



}
