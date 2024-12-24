// Базовый класс для всех фигур
abstract class Shape {
    // Метод для вычисления площади
    abstract double getArea();
    // Метод для вычисления периметра
    abstract double getPerimeter();
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new RuntimeException("There is no figure with such parameters.");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }

    @Override
    double getPerimeter() {
        return 2 * (width + height);
    }
}

// Класс для круга
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new RuntimeException("There is no figure with such parameters.");
        }
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new RuntimeException("There is no figure with such parameters.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getArea() {
        // Формула Герона для площади треугольника
        double s = (a + b + c) / 2; // Полупериметр
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }
}

// Пример
public class Main {
    public static void main(String[] args) {
        try {
            Shape rectangle = new Rectangle(5, 10);
            System.out.println("Rectangle Area: " + rectangle.getArea());
            System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());

            Shape circle = new Circle(7);
            System.out.println("Circle Area: " + circle.getArea());
            System.out.println("Circle Perimeter: " + circle.getPerimeter());

            Shape triangle = new Triangle(3, 4, 5);
            System.out.println("Triangle Area: " + triangle.getArea());
            System.out.println("Triangle Perimeter: " + triangle.getPerimeter());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
