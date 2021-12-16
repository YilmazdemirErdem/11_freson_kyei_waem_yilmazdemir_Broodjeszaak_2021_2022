package model;

import java.util.ArrayList;

public class Bestellijn {
    private String naamBroodje;
    private ArrayList<String> namenBeleg;
    private Broodje broodje;
    private ArrayList<BelegSoort> belegSoorten;

    public Bestellijn(Broodje broodje) {
        setNaamBroodje(broodje.getBroodjesNaam());
        setBroodje(broodje);
        broodje.aanpassenVoorraad(1);
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


}
