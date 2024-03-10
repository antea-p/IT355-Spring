package rs.ac.metropolitan.anteaprimorac5157.interfaces.impl;

import rs.ac.metropolitan.anteaprimorac5157.interfaces.Oblik;

public class Krug implements Oblik {
    private double radijus;

    public Krug() { }

    public Krug(double radijus) {
        this.radijus = radijus;
    }

    @Override
    public double obim() {
        return 2 * Math.PI * radijus;
    }

    @Override
    public double povrsina() {
        return Math.PI * radijus * radijus;
    }
}
