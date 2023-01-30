package lesson4;

public class Triangle {
    private final int a;
    private final int b;
    private final int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateSquare () throws ExceptionSquare {
        if(a < 0 || b < 0 || c < 0) throw new ExceptionSquare("Это не треугольник. У треугольника сторона не может иметь отрицательное значение");
        if (a == 0 || b == 0 || c == 0) throw new ExceptionSquare("Это не треугольник. У треугольника сторона не может быть равна 0");
        if (a>=b+c || b>=a+c || c>=a+b) throw new ExceptionSquare("Это не треугольник. Каждая сторона треугольника меньше суммы двух других сторон");

        double pp = (a + b + c) / 2.0;  // полупериметр
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
    }
}
