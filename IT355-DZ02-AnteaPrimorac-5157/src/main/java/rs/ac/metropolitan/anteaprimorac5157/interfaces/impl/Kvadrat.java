package rs.ac.metropolitan.anteaprimorac5157.interfaces.impl;

import rs.ac.metropolitan.anteaprimorac5157.interfaces.Oblik;

public class Kvadrat implements Oblik {
    private double stranica;

    public Kvadrat() {
    }

    public Kvadrat(double stranica) {
        this.stranica = stranica;
    }

    @Override
    public double obim() {
        return 4 * stranica;
    }

    @Override
    public double povrsina() {
        return stranica * stranica;
    }
}
