package src;

public class Diamond extends Figure
{
    double a;
    double alfa; // kat alfa ostry w stopniach

    Diamond() {}
    Diamond(double a, double alfa)
    {
        this.a = a;
        this.alfa = alfa;
    }

    public void print()
    {
        System.out.println("Diamond");
        System.out.println("a = " + a +  "\talfa = " + alfa);
        System.out.println("Perimeter = " + calculatePerimeter());
        System.out.println("Area = " + calculateArea());
    }

    protected double calculateArea()
    {
        return a*a * Math.sin(Math.toRadians(alfa));
    }

    protected double calculatePerimeter()
    {
        return 4*a;
    }
}
