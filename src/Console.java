package src;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console
{
    String fmtStringEdge = "Podaj dlugosc {0} boku:\n";

    public int askOption(String question, int min, int max)
    {
        Scanner input = new Scanner(System.in);
        int buffer = min - 1;

        while (true)
        {
            System.out.print(question);
            try
            {
                buffer = input.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Niepoprawny typ. Podaj liczbe calkowita");
                buffer = min - 1;
                // TODO potencjalny bug typu overflow
                input.nextLine();
                continue;
            }

            if (buffer < min || buffer > max)
            {
                System.out.println("Prosze o podanie opcji pomiedzy: " + min + " ~ " + max);
            }
            else
            {
                break;
            }
        }

        return buffer;
    }

    public double askHeight(String question)
    {
        Checker checker = new Checker();
        Scanner input = new Scanner(System.in);

        double height = 0;
        while (height <= 0)
        {

            System.out.print(question);
            try
            {
                height = input.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Niepoprawny typ. Podaj liczbe zmienno-przecinkowa");
                height = -1;
                input.nextLine();
                continue;
            }
        }

        return height;
    }

    public Triangle askTriangleData(String question)
    {
        Checker checker = new Checker();
        Scanner input = new Scanner(System.in);

        double a=0, b=0, c=0;

        while(!checker.triangleParamsOk(a,b,c))
        {
            int i = 1;

            System.out.print(question);
            System.out.print(MessageFormat.format(fmtStringEdge, i++));
            try
            {
                a = input.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Niepoprawny typ. Podaj liczbe zmienno-przecinkowa");
                a = -1;
                input.nextLine();
                continue;
            }
            System.out.print(MessageFormat.format(fmtStringEdge, i++));
            try
            {
                b = input.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Niepoprawny typ. Podaj liczbe zmienno-przecinkowa");
                b = -1;
                input.nextLine();
                continue;
            }
            System.out.print(MessageFormat.format(fmtStringEdge, i++));
            try
            {
                c = input.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Niepoprawny typ. Podaj liczbe zmienno-przecinkowa");
                c = -1;
                input.nextLine();
                continue;
            }
        }

        return new Triangle(a,b,c);
    }

    public Rectangle askRectangleData(String question)
    {
        Checker checker = new Checker();
        Scanner input = new Scanner(System.in);

        double a=0, b=0;

        while (!checker.rectangleParamsOk(a,b))
        {
            int i = 1;
            System.out.print(question);
            System.out.print(MessageFormat.format(fmtStringEdge, i++));
            try
            {
                a = input.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Niepoprawny typ. Podaj liczbe zmienno-przecinkowa");
                a = -1;
                input.nextLine();
                continue;
            }
            System.out.print(MessageFormat.format(fmtStringEdge, i++));
            try
            {
                b = input.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Niepoprawny typ. Podaj liczbe zmienno-przecinkowa");
                b = -1;
                input.nextLine();
                continue;
            }
        }

        return new Rectangle(a,b);
    }

    public Diamond askDiamondData(String question)
    {
        Checker checker = new Checker();
        Scanner input = new Scanner(System.in);

        double a=0, alfa = 0;

        while (!checker.diamondParamsOk(a,alfa))
        {
            System.out.print(question);
            System.out.print("Podaj dlugosc boku:\n");
            try
            {
                a = input.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Niepoprawny typ. Podaj liczbe zmienno-przecinkowa");
                a = -1;
                input.nextLine();
                continue;
            }
            System.out.print("Podaj miare kata ostrego rombu:\n");
            try
            {
                alfa = input.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Niepoprawny typ. Podaj liczbe zmienno-przecinkowa");
                alfa = -1;
                input.nextLine();
                continue;
            }
        }

        return new Diamond(a,alfa);
    }

    public Figure askFigureData(String question, int min, int max)
    {
        Figure figure = null;
        switch (askOption(question,
                min,max))
        {
            case 1:
                figure = askTriangleData("\nPodaj dane trojkata:\n" +
                        "Kazdy bok powinien byc dluzszy od zera\n" +
                        "oraz suma dlugosci pozostalych bokow powinna byc wyzsza niz dlugosc najdluzszego boku\n");
                break;
            case 2:
                figure = askRectangleData("\nPodaj dane prostokata:\n" +
                        "Kazdy bok powienien byc dluzszy od zera\n");
                break;
            case 3:
                figure = askDiamondData("\nPodaj dane rombu:\n" +
                        "Bok powinien byc dluzszy od zera\n" +
                        "oraz kat ostry powinien zawierac sie w przedziale (0 ~ 90)\n");
                break;
        }
        return figure;
    }

}
