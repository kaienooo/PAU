package src;

public class Main
{
    static private void threeDimCase(Console c)
    {
        Figure base = null;
        Figure3D figure3d = null;
        double height;
        boolean dataProvided = false;

        while (true)
        {
            switch (c.askOption("\nCo chcesz zrobic?:\n0) Powrot\n1) Wprowadz dane figury\n2) Wypisz dane figury\n",
                    0,1 + ((dataProvided) ? 1 : 0)))
            {
                case 0:
                    return;
                case 1:
                    base = c.askFigureData("\nWybierz podstawe graniastoslupa:\n" +
                            "1) Trojkat\n2) Prostokat\n3) Romb\n",1,3);

                    height = c.askHeight("\nPodaj wysokosc graniastoslupa:\n" +
                            "Dlugosc powinna byc wieksza od zera\n");

                    figure3d = new ThreeDim(base,height);
                    dataProvided = true;
                    // brak breaka nieprzypadkowy

                case 2:
                    System.out.println();
                    figure3d.print();
                    System.out.println();
                    break;
            }
        }
    }

    static private void twoDimCase(Console c)
    {
        Figure figure = null;
        boolean dataProvided = false;

        while (true)
        {
            switch (c.askOption("\nCo chcesz zrobic?:\n0) Powrot\n1) Wprowadz dane figury\n2) Wypisz dane figury\n",
                    0,1 + ((dataProvided) ? 1 : 0)))
            {
                case 0:
                    return;
                case 1:
                    figure = c.askFigureData("\nWybierz figure:\n" +
                            "1) Trojkat\n2) Prostokat\n3) Romb\n", 1,3);
                    dataProvided = true;
                case 2:
                    System.out.println();
                    figure.print();
                    System.out.println();
                    break;
            }
        }
    }

    static public void main(String[] args)
    {
        Console c = new Console();

        while (true)
        {
            switch (c.askOption("\nWitaj!\nKtory tryb pracy programu wybierasz:\n1) 3d\n2) 2d\n0) exit\n",
                    0,2))
            {
                case 0:
                    System.exit(0);
                case 1:
                    threeDimCase(c);
                    break;
                case 2:
                    twoDimCase(c);
                    break;
            }
        }
    }
}
