package model;

import java.util.ArrayList;

public class Bestelling {
    private ArrayList<Bestellijn> bestellijnen;

    public Bestelling(){
        bestellijnen = new ArrayList<Bestellijn>();
    }

    public ArrayList<Bestellijn> getBestellijnen() {
        return bestellijnen;
    }

    public void setBestellijnen(ArrayList<Bestellijn> bestellijnen) {
        this.bestellijnen = bestellijnen;
    }

    public void toevoegenBroodje(Broodje broodje){
        bestellijnen.add(new Bestellijn(broodje));
    }

    public void toevoegenBeleg(Bestellijn bestellijn, BelegSoort belegSoort) {
        bestellijn.voegBelegToe(belegSoort);
    }
}
