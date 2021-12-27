package model;

import javafx.scene.control.Alert;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public void voegBestellijnToe(Bestellijn bestellijn) {
        bestellijnen.add(bestellijn);
    }

    public void verwijderBestellijn(Bestellijn bestellijn) {
        bestellijnen.remove(bestellijn);
    }

    public Double berekenTotaalBedrag(String kortingsStrategie) {
        double totalePrijs = 0;
        for (Bestellijn bestellijn:bestellijnen) {
            totalePrijs += bestellijn.getPrijsBestellijn();
        }

        if (kortingsStrategie == null){
            BigDecimal bd = new BigDecimal(totalePrijs).setScale(2, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }
        if (kortingsStrategie.equals("10% korting op ganse bestelling")){
            totalePrijs -= totalePrijs*0.1;
        }else if(kortingsStrategie.equals("Goedkoopste broodje met beleg gratis")){
            double goedkoopste = Double.MAX_VALUE;
            for (Bestellijn bestellijn:bestellijnen) {
                if (bestellijn.getPrijsBestellijn() < goedkoopste){
                    goedkoopste = bestellijn.getPrijsBestellijn();
                }
            }
            totalePrijs -= goedkoopste;
        }

        BigDecimal bd = new BigDecimal(totalePrijs).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
