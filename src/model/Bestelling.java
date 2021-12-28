package model;

import model.state.*;

import java.util.ArrayList;

public class Bestelling {
    private BestellingState inWacht;
    private BestellingState inBestelling;
    private BestellingState afgesloten;
    private BestellingState betaald;
    private BestellingState inWachtrij;
    private BestellingState inBereiding;
    private ArrayList<Bestellijn> bestellijnen;
    private BestellingState bestellingState;

    public Bestelling(){
        inWacht = new InWacht(this);
        inBestelling = new InBestelling(this);
        afgesloten = new Afgesloten(this);
        betaald = new Betaald(this);
        inWachtrij = new InWachtrij(this);
        inBereiding = new InBereiding(this);
        bestellijnen = new ArrayList<Bestellijn>();
        bestellingState = new InWacht(this);
    }

    public ArrayList<Bestellijn> getBestellijnen() {
        return bestellijnen;
    }

    public BestellingState getInWacht() {
        return inWacht;
    }

    public BestellingState getInBestelling() {
        return inBestelling;
    }

    public BestellingState getAfgesloten() {
        return afgesloten;
    }

    public BestellingState getBetaald() {
        return betaald;
    }

    public BestellingState getInWachtrij() {
        return inWachtrij;
    }

    public BestellingState getInBereiding() {
        return inBereiding;
    }

    public BestellingState getBestellingState() {
        return bestellingState;
    }

    public void setBestellijnen(ArrayList<Bestellijn> bestellijnen) {
        this.bestellijnen = bestellijnen;
    }

    public void setState(BestellingState bestellingState){
        this.bestellingState = bestellingState;
    }

    public void nieuweBestelling() {
       bestellingState.maakNieuweBestelling();
    }

    public void toevoegenBroodje(Broodje broodje){
        //bestellijnen.add(new Bestellijn(broodje));
        bestellingState.voegBestellijnToe(broodje);
    }

    public void toevoegenBeleg(Bestellijn bestellijn, BelegSoort belegSoort) {
        //bestellijn.voegBelegToe(belegSoort);
        bestellingState.voegBelegToe(bestellijn, belegSoort);
    }

    public void voegDezelfdeBestellijnToe(Bestellijn bestellijn) {
        //bestellijnen.add(bestellijn);
        bestellingState.voegIdentiekBroodjeToe(bestellijn);
    }

    public void verwijderBestellijn(Bestellijn bestellijn) {
        //bestellijnen.remove(bestellijn);
        bestellingState.verwijderBroodje(bestellijn);
    }

    public Double berekenTotaalBedrag(String kortingsStrategie) {
        /*double totalePrijs = 0;
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
        return bd.doubleValue();*/
        return bestellingState.afsluiten(kortingsStrategie);
    }

    public void annuleer(){
        bestellingState.annuleren();
    }
}
