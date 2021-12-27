package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Bestellijn {
    private String naamBroodje;
    private ArrayList<String> namenBeleg;
    private Broodje broodje;
    private ArrayList<BelegSoort> belegSoorten;
    private HashMap<Broodje, ArrayList<BelegSoort>> bestellijnen;

    public Bestellijn(Broodje broodje) {
        setNaamBroodje(broodje.getBroodjesNaam());
        setBroodje(broodje);
        this.belegSoorten = new ArrayList<>();
        this.namenBeleg = new ArrayList<>();
    }

    public Broodje getBroodje() {
        return broodje;
    }

    public void setBroodje(Broodje broodje) {
        this.broodje = broodje;
    }

    public ArrayList<BelegSoort> getBelegSoort() {
        return belegSoorten;
    }

    public void setBelegSoort(ArrayList<BelegSoort> belegSoorten) {
        this.belegSoorten = belegSoorten;
    }

    public String getNaamBroodje() {
        return naamBroodje;
    }

    public void setNaamBroodje(String naamBroodje) {
        this.naamBroodje = naamBroodje;
    }

    public ArrayList<String> getNamenBeleg() {
        return namenBeleg;
    }

    public void setNamenBeleg(ArrayList<String> namenBeleg) {
        this.namenBeleg = namenBeleg;
    }

    public void voegBelegToe(BelegSoort belegSoort){
        this.belegSoorten.add(belegSoort);
        this.namenBeleg.add(belegSoort.getBelegNaam());
    }

    public double getPrijsBestellijn(){
        double totalePrijs = this.broodje.getBroodjesPrijs();
        for (BelegSoort belegSoort:belegSoorten) {
            totalePrijs += belegSoort.getBelegPrijs();
        }
        return totalePrijs;
    }
}
