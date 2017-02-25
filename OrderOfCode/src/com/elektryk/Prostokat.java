package com.elektryk;

/**
 * Created by Konrad Bochnia, Pawe³ Ko³ek on 25.02.2017.
 */
public class Prostokat {
    double xMax, xMin, yMax, yMin;

    public Prostokat(double xMin, double xMax, double yMin, double yMax) {
        this.xMax = xMax;
        this.xMin = xMin;
        this.yMax = yMax;
        this.yMin = yMin;
    }

    @Override
    public String toString() {
        return "[" + xMin +";"+xMax +";" + yMin +";" + yMax +']';
    }

    public boolean zawieraPunkt(double x, double y) {
        return (x >= xMin && x <= xMax) &&
                (y >= yMin && y <= yMax);
    }

    public Linia lewy() {
        return new Linia(xMin, yMin, xMin, yMax);
    }

    public Linia prawy() {
        return new Linia(xMax, yMin, xMax, yMax);
    }

    public Linia gorny() {
        return new Linia(xMin, yMax, xMax, yMax);
    }

    public Linia dolny() {
        return new Linia(xMin, yMin, xMax, yMin);
    }
}
