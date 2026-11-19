package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class KoscTest {
    @Test
    void testKonstruktorPoprawnaWartosc() {
        Kosc kosc = new Kosc(4);
        assertEquals(4, kosc.liczbaOczek);
        assertEquals("[: :]", kosc.pobierzSymbol());
        assertTrue(kosc.dostepna);
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "7",
            "-2"
    })
    void testKonstruktorNiepoprawnaWartosc(int wartosc) {
        Kosc kosc = new Kosc(wartosc);
        assertEquals(0, kosc.liczbaOczek);
        assertEquals("[ ]", kosc.pobierzSymbol());
    }

    @Test
    void testBlokowanieKosci() {
        Kosc kosc = new Kosc(3);
        int poprzedniaWartosc = kosc.liczbaOczek;
        kosc.zablokuj();
        kosc.rzuc();
        assertFalse(kosc.dostepna);
        assertEquals(poprzedniaWartosc, kosc.liczbaOczek);
    }

    @Test
    void testLicznikInstancji() {
        int przed = Kosc.liczbaInstancji;
        new Kosc(2);
        new Kosc();
        assertEquals(przed + 2, Kosc.liczbaInstancji);
    }

    @ParameterizedTest
    @CsvSource({
            "0, zero",
            "1, jeden",
            "2, dwa",
            "3, trzy",
            "4, cztery",
            "5, piec",
            "6, szesc"
    })
    void testWartoscSlownie(int wartosc, String oczekiwany) {
        Kosc kosc = new Kosc(wartosc);
        assertEquals(oczekiwany, kosc.wartoscSlownie());
    }
}
