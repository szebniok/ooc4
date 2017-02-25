package com.elektryk;

/**
 * Created by Konrad Bochnia, Pawe³ Ko³ek on 25.02.2017.
 */
public class Punkt {
    public double x, y;

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return  Math.round(x * 1000d) / 1000d +
                ";" + Math.round(y * 1000d) / 1000d
                ;
    }
}
