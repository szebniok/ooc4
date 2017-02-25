package com.elektryk;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Konrad Bochnia, Pawe³ Ko³ek on 25.02.2017.
 */
public class Parser {
    String nazwaPliku;
    File plik;

    public ArrayList<Linia> linie;

    Prostokat prostokat;

    public Parser(String nazwaPliku) throws IOException {
        linie = new ArrayList<>();

        plik = new File(nazwaPliku);

        FileReader fr = new FileReader(plik);

        BufferedReader burf = new BufferedReader(fr);

        //komentarz
        String linia = burf.readLine();

        //prostokat
        linia = burf.readLine();
        linia = linia.replace("[", "").replace("]", "");
        String czesci[] = linia.split(";");

        double xmin = Double.parseDouble(czesci[0]);
        double xmax = Double.parseDouble(czesci[1]);
        double ymin = Double.parseDouble(czesci[2]);
        double ymax = Double.parseDouble(czesci[3]);

        prostokat = new Prostokat(xmin, xmax, ymin, ymax);

        //komentarz
        linia = burf.readLine();

        //punkty
        //pierwszy punkt
        linia = burf.readLine();
        double x1, y1, x2, y2;
        czesci = linia.split(";");

        x1 = Double.parseDouble(czesci[0].replace(",", "."));
        y1 = Double.parseDouble(czesci[1].replace(",", "."));

        linia = burf.readLine();
        czesci = linia.split(";");

        x2 = Double.parseDouble(czesci[0].replace(",", "."));
        y2 = Double.parseDouble(czesci[1].replace(",", "."));

        linie.add(new Linia(x1, y1, x2, y2));

        while((linia =  burf.readLine())!= null) {
            Linia poprzednia = linie.get(linie.size()-1);

            x1 = poprzednia.x2; y1 = poprzednia.y2;

            czesci = linia.split(";");

            x2 = Double.parseDouble(czesci[0].replace(",", "."));
            y2 = Double.parseDouble(czesci[1].replace(",", "."));

            linie.add(new Linia(x1, y1, x2, y2));


        }

    }



}
