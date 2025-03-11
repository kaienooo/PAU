import java.util.ArrayList;

enum fuelType
{
    DIESEL,
    DIESEL_HYBRID,
    GASOLINE,
    GASOLINE_LPG,
    GASOLINE_CNG,
    GASOLINE_HYBRID,
    ELECTRIC
}

class Color
{
    private String name;
    private int hex;

    public Color(String name, int hex)
    {
        this.name = name;
        this.hex = hex;
    }

    public String getColor()
    {
        return this.name;
    }

    public void changeColor(Color newColor)
    {
        this.name = newColor.name;
        this.hex = newColor.hex;
    }
}

abstract class Vehicle
{
    protected int fuelTankCapacity;
    protected Color color;

    protected String manufacturer;
    protected String model;

    protected fuelType fuelType;

    protected String getFuelTypeString() {
        return switch (fuelType) {
            case DIESEL, DIESEL_HYBRID -> "DIESEL";
            case GASOLINE, GASOLINE_HYBRID -> "BENZYNA";
            case GASOLINE_LPG -> "BENZYNA+LPG";
            case GASOLINE_CNG -> "BENZYNA+CNG";
            case ELECTRIC -> "ELEKTRYK";
        };
    }

    abstract public void drive();
    public void info()
    {
        System.out.println("Vehicle info:\n"
                + manufacturer + " " + model + "\n" +
                "Paliwo: \n" +
                "Rodzaj paliwa: " + getFuelTypeString() + "\n" +
                "Pojemnosc zbiornika: " + fuelTankCapacity + "\n" +
                "Kolor: " + color.getColor());
    }
}

class Car extends Vehicle
{
    public Car(int fuelTankCapacity, Color color, String manufacturer, String model,fuelType fuelType)
    {
        this.fuelTankCapacity = fuelTankCapacity;
        this.color = color;
        this.manufacturer = manufacturer;
        this.model = model;
        this.fuelType = fuelType;
    }

    public void drive()
    {
        System.out.println("Car driving");
    }
}

class Truck extends Vehicle
{

    public Truck(int fuelTankCapacity, Color color, String manufacturer, String model, fuelType fuelType)
    {
        this.fuelTankCapacity = fuelTankCapacity;
        this.color = color;
        this.manufacturer = manufacturer;
        this.model = model;
        this.fuelType = fuelType;
    }

    public void drive() {
        System.out.println("Truck driving");
    }
}

/*
public class Main
{
    public static void main(String[] args)
    {
        Car mycar = new Car(40,
                new Color("Srebrny",0xC0C0C0),
                "Skoda",
                "Fabia",
                fuelType.DIESEL);

        Truck mytruck = new Truck(600,
                new Color("Czerwony", 0xFF0000),
                "Volvo",
                "FH",
                fuelType.DIESEL);

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(mycar);
        vehicles.add(mytruck);

        for (Vehicle vehicle : vehicles)
        {
            vehicle.drive();
            vehicle.info();
        }
    }
}
*/