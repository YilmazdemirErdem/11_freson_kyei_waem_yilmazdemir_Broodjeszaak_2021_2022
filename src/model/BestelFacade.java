package model;

import model.database.BelegDatabase;
import model.database.BroodjesDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import utilities.Observer;

import java.util.ArrayList;
import java.util.HashMap;

public class BestelFacade implements Subject {
    private int nr_bestelling = 0;
    private int aantal_broodjes = 0;
    private double totalePrijs = 0.0;
    private int aantalInWachtrij = 0;
    private HashMap<BestellingEvents, ArrayList<Observer>> observerMap = new HashMap<>();
    private BroodjesDatabase broodjesDatabase = new BroodjesDatabase(LoadSaveStrategyEnum.TEKST);
    private BelegDatabase belegDatabase = new BelegDatabase(LoadSaveStrategyEnum.TEKST);
    private Bestelling bestelling = new Bestelling();

    public BestelFacade() {
        initiateObserverMap();
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    private void initiateObserverMap() {
        for (BestellingEvents bestellingEvents : BestellingEvents.values()) {
            this.observerMap.put(bestellingEvents, new ArrayList<Observer>());
        }
    }

    public void nieuweBestelling() {
         bestelling.nieuweBestelling();
    }

    public void toevoegenBroodje(Broodje broodje){
        bestelling.toevoegenBroodje(broodje);
    }

    public void toevoegenBeleg(Bestellijn bestellijn, BelegSoort belegSoort) {
        bestelling.toevoegenBeleg(bestellijn, belegSoort);
    }

    public ArrayList<Bestellijn> getLijstBestellijnen(){
        return bestelling.getBestellijnen();
    }

    public ArrayList<Broodje> getOpVoorraadLijstBroodjes(){
        return broodjesDatabase.getOpVoorraadLijstBroodjes();
    }

    public ArrayList<BelegSoort> getOpVoorraadLijstBelegSoorten() {
        return belegDatabase.getOpVoorraadLijstBelegSoorten();
    }

    public void voegZelfdeToe(Bestellijn bestellijn) {
        Broodje broodjeOriginal = bestellijn.getBroodje();
        Broodje broodje = new Broodje(broodjeOriginal.getBroodjesNaam(), broodjeOriginal.getBroodjesPrijs(),
                broodjeOriginal.getBroodjesStock(), broodjeOriginal.getAantalBroodjesVerkocht());
        Bestellijn bestellijnCopy = new Bestellijn(broodje);

        for (BelegSoort belegSoort:bestellijn.getBelegSoort()) {
            bestellijnCopy.voegBelegToe(belegSoort);
        }

        bestelling.voegDezelfdeBestellijnToe(bestellijnCopy);
    }

    public void verwijderBestellijn(Bestellijn bestellijn) {
        bestelling.verwijderBestellijn(bestellijn);
    }

    public void annuleerBestelling() {
        bestelling.annuleer();
    }

    public void berekenTotaalBedrag(String kortingsStrategie) {
        totalePrijs = bestelling.berekenTotaalBedrag(kortingsStrategie);
    }

    public void betaalBestelling() {
        bestelling.betalen();
    }

    public void zendNaarKeuken() {
        bestelling.naarKeuken();
    }

    public void notifyObservers(BestellingEvents bestellingEvents, int nrBestelling, int aantalBroodjes, double totalePrijs, int aantalInWachtrij){
        for (Observer obs: observerMap.get(bestellingEvents)){
            obs.update(nrBestelling, aantalBroodjes, totalePrijs, aantalInWachtrij);
        }
    }

    public void updateBy(BestellingEvents bestellingEvents, int nr_bestelling_extra, int aantal_broodjes_extra, int aantal_InWachtrij){
        nr_bestelling += nr_bestelling_extra;
        aantal_broodjes += aantal_broodjes_extra;
        aantalInWachtrij += aantal_InWachtrij;
        notifyObservers(bestellingEvents, nr_bestelling, aantal_broodjes, totalePrijs, aantalInWachtrij);
    }

    public void addObserverToEvent(BestellingEvents bestellingEvents, Observer obs){
        observerMap.get(bestellingEvents).add(obs);
    }
}
