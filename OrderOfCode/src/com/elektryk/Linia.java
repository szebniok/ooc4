package com.elektryk;

/**
 * Created by Konrad Bochnia, Pawe³ Ko³ek on 25.02.2017.
 */
public class Linia {
    public double x1, y1, x2, y2;

    public Linia(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double m() {
        return (y2 - y1) / (x2 - x1);
    }

    @Override
    public String toString() {
        return "Linia{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    // x, y = output
    public Punkt punkt_przeciecia(Linia inna) {
        double x = ( ((x2*y1 - x1*y2)*(inna.x2 - inna.x1)) - ((inna.x2*inna.y1 - inna.x1*inna.y2)*(x2 - x1)) )
                /  ( ((x2-x1)*(inna.y2 - inna.y1)) - ((inna.x2 - inna.x1)*(y2-y1)) );

        double y = ( ((x2*y1 - x1*y2)*(inna.y2 - inna.y1)) - ((inna.x2*inna.y1 - inna.x1*inna.y2)*(y2 - y1)) )
                /  ( ((x2-x1)*(inna.y2 - inna.y1)) - ((inna.x2 - inna.x1)*(y2-y1)) );

        return new Punkt(x, y);
    }

    public boolean przecina(Linia inna) {
        Punkt punkt = punkt_przeciecia(inna);

        return ((x1 <= punkt.x) && (punkt.x <= x2)) && ((inna.x1 <= punkt.x) && (punkt.x <= inna.x2));
    }
}
