package org.example;

import java.util.Arrays;

public class ZestawKosci {

    private Kosc[] kosci = new Kosc[5];

    public ZestawKosci() {
        for (int i = 0; i < 5; i++) {
            kosci[i] = new Kosc();
        }
    }

    public ZestawKosci(int[] wartosci) {
        if (wartosci == null || wartosci.length != 5) {
            throw new IllegalArgumentException(
                    "Tablica musi zawierać dokładnie 5 wartości."
            );
        }

        for (int i = 0; i < 5; i++) {
            kosci[i] = new Kosc(wartosci[i]);
        }
    }

    public void rzucDostepnymi() {
        for (Kosc kosc : kosci) {
            kosc.rzuc();
        }
    }

    public boolean zablokujKosc(int numerKosci) {
        if (numerKosci < 1 || numerKosci > 5) {
            return false;
        }
        kosci[numerKosci - 1].zablokuj();
        return true;
    }

    public void odblokujWszystkie() {
        for (Kosc kosc : kosci) {
            kosc.odblokuj();
        }
    }

    public int obliczSumeWszystkich() {
        int suma = 0;
        for (Kosc kosc : kosci) {
            suma += kosc.liczbaOczek;
        }
        return suma;
    }

    public int obliczSumePowtorzen() {
        int[] licznik = new int[7];
        for (Kosc kosc : kosci) {
            licznik[kosc.liczbaOczek]++;
        }
        int suma = 0;
        for (Kosc kosc : kosci) {
            int wartosc = kosc.liczbaOczek;
            if (licznik[wartosc] >= 2) {
                suma += wartosc;
            }
        }
        return suma;
    }

    public String rozpoznajUklad() {
        int[] licznik = new int[7];
        for (Kosc kosc : kosci) {
            licznik[kosc.liczbaOczek]++;
        }
        int pary = 0;
        int trojki = 0;
        int czworki = 0;
        int piatki = 0;
        for (int i = 1; i <= 6; i++) {
            if (licznik[i] == 2) pary++;
            if (licznik[i] == 3) trojki++;
            if (licznik[i] == 4) czworki++;
            if (licznik[i] == 5) piatki++;
        }
        if (piatki == 1) {
            return "Generał";
        }
        if (czworki == 1) {
            return "Kareta";
        }
        if (trojki == 1 && pary == 1) {
            return "Ful";
        }
        if (czyDuzyStrit(licznik)) {
            return "Duży strit";
        }
        if (czyMalyStrit(licznik)) {
            return "Mały strit";
        }
        if (trojki == 1) {
            return "Trójka";
        }
        if (pary == 2) {
            return "Dwie pary";
        }
        if (pary == 1) {
            return "Para";
        }
        return "Brak układu";
    }

    private boolean czyDuzyStrit(int[] licznik) {
        boolean pierwszy = true;
        boolean drugi = true;
        for (int i = 1; i <= 5; i++) {
            if (licznik[i] != 1) {
                pierwszy = false;
            }
        }

        for (int i = 2; i <= 6; i++) {
            if (licznik[i] != 1) {
                drugi = false;
            }
        }

        return pierwszy || drugi;
    }

    private boolean czyMalyStrit(int[] licznik) {
        for (int start = 1; start <= 3; start++) {
            boolean znaleziono = true;
            for (int i = start; i < start + 4; i++) {
                if (licznik[i] == 0) {
                    znaleziono = false;
                    break;
                }
            }
            if (znaleziono) {
                return true;
            }
        }
        return false;
    }

    public Kosc pobierzKosc(int indeks) {
        return kosci[indeks];
    }

    public void wyswietlKosci() {
        for (int i = 0; i < 5; i++) {
            Kosc kosc = kosci[i];
            System.out.println(
                    "Kość " + (i + 1) + ": " + kosc.pobierzSymbol() + " | Oczka: " + kosc.liczbaOczek + (kosc.dostepna ? " [DOSTĘPNA]" : " [ZABLOKOWANA]"));
        }
    }
}
