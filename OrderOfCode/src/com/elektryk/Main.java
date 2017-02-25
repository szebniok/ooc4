package com.elektryk;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    Parser p;

    ArrayList<Punkt> wynik;

    public Main(String filename) throws IOException {


        p = new Parser(filename);



        Prostokat prostokat = p.prostokat;

        ArrayList<Linia> linie = p.linie;
        wynik = new ArrayList<>();

        for(Linia linia : linie) {
            /*if (prostokat.lewy().przecina(linia) ||
                prostokat.prawy().przecina(linia) ||
                prostokat.gorny().przecina(linia)||
                prostokat.dolny().przecina(linia))

            {
                System.out.println(linia.toString());
            }*/
            Linia test = prostokat.lewy();
            if (prostokat.lewy().przecina(linia)) {
                wynik.add( prostokat.lewy().punkt_przeciecia(linia) );
            }
            if (prostokat.prawy().przecina(linia)) {
                wynik.add( prostokat.prawy().punkt_przeciecia(linia) );
            }
            if (prostokat.gorny().przecina(linia)) {
                wynik.add( prostokat.gorny().punkt_przeciecia(linia) );
            }
            if (prostokat.dolny().przecina(linia)) {
                wynik.add( prostokat.dolny().punkt_przeciecia(linia) );
            }
            if (prostokat.zawieraPunkt(linia.x1, linia.y1)) {
                wynik.add( new Punkt(linia.x1, linia.y1) );
            }

        }

        //ostatni punkt
        Linia ostatnia = linie.get(linie.size() - 1);
        if (prostokat.zawieraPunkt(ostatnia.x1, ostatnia.y1)) {
            wynik.add( new Punkt(ostatnia.x1, ostatnia.y1) );
        }

        //sortuj
        Collections.sort(wynik, (o1, o2) -> (o1.x < o2.x) ? -1: 1);

        HashSet<String> byly = new HashSet<>();

        for( Punkt p : wynik) {
            //System.out.println(p.toString());
        }

        String czesci[] = filename.split("\\.");

        try(PrintWriter out = new PrintWriter(czesci[0] + "_out." + czesci[1])) {
            DecimalFormat df = new DecimalFormat("#.###");
            out.println("# " + filename);
            out.println("# [" + df.format(prostokat.xMin) + ";" + df.format(prostokat.xMax) + ";" + df.format(prostokat.yMin) + ";" + df.format(prostokat.yMax) + "]");
            out.println("# Konrad Bochnia, Paweł Kołek");
            for ( Punkt p: wynik) {
               // out.println(p.toString());
                if (byly.contains(p.toString())) continue;

                if (p.y > prostokat.yMax) continue;
                if (p.x > prostokat.xMax) continue;

                byly.add(p.toString());
                df.setRoundingMode(RoundingMode.HALF_UP);

                out.println(df.format(p.x) + ";" + df.format(p.y) + ";");
            }
        }



    }

    public static void main(String[] args) throws IOException {

        //new Main(args[0]);
        new Main("D:\\zestaw.csv");

    }
}
