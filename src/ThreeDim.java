package src;

public class ThreeDim extends Figure3D
{
    Figure base;
    double height;

    ThreeDim()
    {}

    ThreeDim(Figure base, double height)
    {
        this.base = base;
        this.height = height;
    }

    public void print()
    {
        System.out.println("Three Dim");
        System.out.println("3d Height: " + height + "\n");
        System.out.println("3d Base: ");
        base.print();
        System.out.println("\n3d Surface: " +  calculateSurfaceArea());
        System.out.println("3d Volume: " +  calculateVolume());

    }

    protected double calculateSurfaceArea()
    {
        return base.calculateArea() * 2 + height * base.calculatePerimeter();
    }

    protected double calculateVolume()
    {
        return base.calculateArea()*height;
    }
}
