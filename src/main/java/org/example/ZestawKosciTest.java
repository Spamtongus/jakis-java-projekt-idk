package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZestawKosciTest {

    @Test
    void testBlokowanieKosciPodczasRzutu() {
        int[] wartosci = {1, 2, 3, 4, 5};
        ZestawKosci zestaw = new ZestawKosci(wartosci);
        zestaw.zablokujKosc(1);
        int wartosc = zestaw.pobierzKosc(0).liczbaOczek;
        zestaw.rzucDostepnymi();
        assertEquals(wartosc, zestaw.pobierzKosc(0).liczbaOczek);
        assertFalse(zestaw.pobierzKosc(0).dostepna);
    }

    @Test
    void testObliczanieSumyPowtorzen() {
        ZestawKosci zestaw1 = new ZestawKosci(new int[]{1, 2, 3, 4, 5});
        assertEquals(0, zestaw1.obliczSumePowtorzen());
        ZestawKosci zestaw2 = new ZestawKosci(new int[]{2, 5, 2, 6, 2});
        assertEquals(6, zestaw2.obliczSumePowtorzen());
    }

    @Test
    void testRozpoznawanieFulIKarety() {
        ZestawKosci ful = new ZestawKosci(new int[]{3, 5, 3, 5, 3});
        assertEquals("Ful", ful.rozpoznajUklad());
        ZestawKosci kareta = new ZestawKosci(new int[]{2, 2, 6, 2, 2});
        assertEquals("Kareta", kareta.rozpoznajUklad());
    }

    @Test
    void testRozpoznawanieStritow() {
        ZestawKosci malyStrit1 = new ZestawKosci(new int[]{1, 2, 3, 4, 6});
        assertEquals("Mały strit", malyStrit1.rozpoznajUklad());
        ZestawKosci malyStrit2 = new ZestawKosci(new int[]{1, 2, 3, 4, 2});
        assertEquals("Mały strit", malyStrit2.rozpoznajUklad());
        ZestawKosci duzyStrit = new ZestawKosci(new int[]{2, 3, 4, 5, 6});
        assertEquals("Duży strit", duzyStrit.rozpoznajUklad());
    }

    @Test
    void testBlokowanieKosciPoprawneINiepoprawneNumery() {
        ZestawKosci zestaw = new ZestawKosci(new int[]{1, 2, 3, 4, 5});
        for (int i = 1; i <= 5; i++) {
            assertTrue(zestaw.zablokujKosc(i));
        }
        assertFalse(zestaw.zablokujKosc(0));
        assertFalse(zestaw.zablokujKosc(6));
    }
}
