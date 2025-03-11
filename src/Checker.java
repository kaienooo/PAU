package src;

public class Checker {
    public boolean triangleParamsOk(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }

        if (a >= b && a >= c) {   // a najwieksze
            return b + c > a;
        }

        if (b >= a && b >= c) {   // b najwieksze
            return a + c > b;
        }
        // c najwieksze
        return a + b > c;
    }

    public boolean rectangleParamsOk(double a, double b)
    {
        return a > 0 && b > 0;
    }

    public boolean diamondParamsOk(double a, double alfa)
    {
        return a > 0  && alfa > 0 && alfa < 90;
    }
}
