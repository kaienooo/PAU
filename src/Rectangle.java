package src;

public class Rectangle extends Figure
{
    double a;
    double b;
    Rectangle() {}
    Rectangle(double a, double b)
    {
        this.a = a;
        this.b = b;
    }
    public void print()
    {
        System.out.println("Rectangle");
        System.out.println("a = " + a +  "\tb = " + b);
        System.out.println("Perimeter = " + calculatePerimeter());
        System.out.println("Area = " + calculateArea());
    }

    protected double calculateArea() {
        return a*b;
    }

    protected double calculatePerimeter()
    {
        return 2*(a+b);
    }

}
