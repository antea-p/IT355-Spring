package rs.ac.metropolitan.anteaprimorac5157.interfaces.impl;

import rs.ac.metropolitan.anteaprimorac5157.interfaces.Oblik;

public class JednakostranicniTrougao implements Oblik {
    private double stranica;

    public JednakostranicniTrougao() {
    }

    public JednakostranicniTrougao(double stranica) {
        this.stranica = stranica;
    }

    @Override
    public double obim() {
        return 3 * stranica;
    }

    @Override
    public double povrsina() {
        return (Math.sqrt(3) / 4) * stranica * stranica;
    }
}

