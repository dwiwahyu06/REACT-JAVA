public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7, "Merah");
        circle.draw();
        System.out.println("Luas lingkaran: " + circle.area());
        System.out.println("Luas lingkaran dari diameter 14: " + circle.area(14));

        System.out.println();

        Square square = new Square(5, "Biru");
        square.draw();
        System.out.println("Luas persegi: " + square.area());
        System.out.println("Luas persegi panjang 5x6: " + square.area(5, 6));
    }
}

interface Drawable {
    void draw();
}

abstract class Shape implements Drawable {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double area();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    public double area(double diameter) {
        double r = diameter / 2;
        return Math.PI * r * r;
    }

    @Override
    public void draw() {
        System.out.println("Menggambar lingkaran berwarna " + color);
    }
}

class Square extends Shape {
    private double side;

    public Square(double side, String color) {
        super(color);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    public double area(double panjang, double lebar) {
        return panjang * lebar;
    }

    @Override
    public void draw() {
        System.out.println("Menggambar persegi berwarna " + color);
    }
}
