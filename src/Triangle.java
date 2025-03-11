package src;

public class Triangle extends Figure {
    double a;
    double b;
    double c;

    Triangle() {}
    Triangle(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void print()
    {
        System.out.println("Triangle");
        System.out.println("a = " + a +  "\tb = " + b + "\tc = " + c);
        System.out.println("Perimeter = " + calculatePerimeter());
        System.out.println("Area = " + calculateArea());
    }

    protected double calculateArea()
    {
        double halfOfPerimeter = calculatePerimeter()/2;
        return Math.sqrt(halfOfPerimeter * (halfOfPerimeter - a) * (halfOfPerimeter - b) * (halfOfPerimeter -c));
    }

    protected double calculatePerimeter()
    {
        return a + b + c;
    }

}
