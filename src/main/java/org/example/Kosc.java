package org.example;

import java.util.Random;

public class Kosc {

    public static int liczbaInstancji = 0;
    public String[] symbole = {
            "[ ]", "[ . ]", "[ : ]", "[.:]",
            "[: :]", "[:.:]", "[:::]"
    };

    public int liczbaOczek;
    public int identyfikatorSymbolu;
    public boolean dostepna;

    private static final Random random = new Random();

    public Kosc(int wartosc) {
        if (wartosc < 1 || wartosc > 6) {
            wartosc = 0;
        }

        this.liczbaOczek = wartosc;
        this.identyfikatorSymbolu = wartosc;
        this.dostepna = true;
        liczbaInstancji++;
    }

    public Kosc() {

        this.liczbaOczek = random.nextInt(6) + 1;
        this.identyfikatorSymbolu = liczbaOczek;
        this.dostepna = true;
        liczbaInstancji++;
    }

    public void rzuc() {

        if (dostepna) {
            liczbaOczek = random.nextInt(6) + 1;
            identyfikatorSymbolu = liczbaOczek;
        }
    }

    public void zablokuj() {
        dostepna = false;
    }

    public void odblokuj() {
        dostepna = true;
    }

    public String wartoscSlownie() {
        switch (liczbaOczek) {
            case 0:
                return "zero";
            case 1:
                return "jeden";
            case 2:
                return "dwa";
            case 3:
                return "trzy";
            case 4:
                return "cztery";
            case 5:
                return "piec";
            case 6:
                return "szesc";
            default:
                return "nieznana";
        }
    }

    public String pobierzSymbol() {
        return symbole[identyfikatorSymbolu];
    }
}
