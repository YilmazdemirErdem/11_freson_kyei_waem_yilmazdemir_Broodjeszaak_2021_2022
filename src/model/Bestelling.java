package model;

import java.util.ArrayList;

public class Bestelling {
    private ArrayList<Bestellijn> Bestellijen;

    public Bestelling(ArrayList<Bestellijn> bestellijen) {
        setBestellijen(bestellijen);
    }

    public ArrayList<Bestellijn> getBestellijen() {
        return Bestellijen;
    }

    public void setBestellijen(ArrayList<Bestellijn> bestellijen) {
        Bestellijen = bestellijen;
    }

    public void toevoegenBroodje(Broodje broodje){
        Bestellijen.add(new Bestellijn(broodje));
    }
}
