package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("GRA W KOSCI");
        System.out.println("\nETAP 1 - POJEDYNCZA KOSC");
        System.out.print("Podaj wartosc kosci (1-6): ");
        int wartosc = scanner.nextInt();
        scanner.nextLine();
        Kosc kosc1 = new Kosc(wartosc);
        wyswietlKosc(kosc1);
        System.out.println("\nLosowanie drugiej kosci");
        Kosc kosc2 = new Kosc();
        wyswietlKosc(kosc2);
        System.out.println("\nETAP 2 - TURA GRY");
        ZestawKosci zestaw = new ZestawKosci();
        System.out.println("\nPoczatkowy stan kosci:");
        zestaw.wyswietlKosci();
        for (int rzut = 1; rzut <= 2; rzut++) {
            System.out.println("\nPRZERZUT " + rzut);
            System.out.println("Podaj numery kosci do zablokowania (1-5).");
            System.out.println("Wpisz 0, aby zakonczyc ture.");
            String linia = scanner.nextLine().trim();
            if (linia.isEmpty()) {
                System.out.println("Nie podano numerow kosci.");
            } else {
                String[] numery = linia.split("\\s+");
                boolean koniecTury = false;
                for (String numer : numery) {
                    try {
                        int nr = Integer.parseInt(numer);
                        if (nr == 0) {
                            koniecTury = true;
                            break;
                        }
                        if (zestaw.zablokujKosc(nr)) {
                            System.out.println("Zablokowano kosc nr " + nr);
                        } else {
                            System.out.println("Nieprawidlowy numer kosci: " + nr);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Podano nieprawidlowe dane: " + numer);
                    }
                }
                if (koniecTury) {
                    System.out.println("Zakonczenie tury.");
                    break;
                }
            }
            zestaw.rzucDostepnymi();
            System.out.println("\nStan kosci po przerzucie:");
            zestaw.wyswietlKosci();
        }
        System.out.println("\nWYNIK KONCOWY");
        zestaw.wyswietlKosci();
        System.out.println("\nSuma wszystkich oczek: " + zestaw.obliczSumeWszystkich());
        System.out.println("Suma powtorzen: " + zestaw.obliczSumePowtorzen());
        System.out.println("Rozpoznany uklad: " + zestaw.rozpoznajUklad());
        System.out.println("\nKoniec gry!");
        scanner.close();
    }
    public static void wyswietlKosc(Kosc kosc) {
        System.out.println("\nLiczba utworzonych kosci: " + Kosc.liczbaInstancji);
        System.out.println("Liczba oczek: " + kosc.liczbaOczek);
        System.out.println("Wartosc slownie: " + kosc.wartoscSlownie());
        System.out.println("Symbol: " + kosc.pobierzSymbol());
        System.out.println("Dostepnosc: " + (kosc.dostepna ? "DOSTEPNA" : "ZABLOKOWANA"));
    }
}
