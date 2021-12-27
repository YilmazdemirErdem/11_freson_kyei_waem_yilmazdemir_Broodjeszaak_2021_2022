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
    private BestellingState bestellingState;
    private HashMap<BestellingEvents, ArrayList<Observer>> observerMap = new HashMap<>();
    private BroodjesDatabase broodjesDatabase = new BroodjesDatabase(LoadSaveStrategyEnum.TEKST);
    private BelegDatabase belegDatabase = new BelegDatabase(LoadSaveStrategyEnum.TEKST);
    private Bestelling bestelling = new Bestelling();

    public BestelFacade() {
        //bestellingState = new BestellingState.changeState(BestellingEvents.IN_WACHT);
        initiateObserverMap();
    }

    private void initiateObserverMap() {
        for (BestellingEvents bestellingEvents : BestellingEvents.values()) {
            this.observerMap.put(bestellingEvents, new ArrayList<Observer>());
        }
    }

    public void changeState(BestellingEvents bestellingEvents) {
        bestellingState.changeState(bestellingEvents);
    }

    public void toevoegenBroodje(Broodje broodje){
        bestelling.toevoegenBroodje(broodje);
    }

    public void toevoegenBeleg(Bestellijn bestellijn, BelegSoort belegSoort) {
        bestelling.toevoegenBeleg(bestellijn, belegSoort);
    }

    public void voegBestellijnToe(String broodjesNaam){

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

        bestelling.voegBestellijnToe(bestellijnCopy);
    }

    public void verwijderBestellijn(Bestellijn bestellijn) {
        bestelling.verwijderBestellijn(bestellijn);
    }

    public Double berekenTotaalBedrag(String kortingsStrategie) {
        return bestelling.berekenTotaalBedrag(kortingsStrategie);
    }

    public void notifyObservers(BestellingEvents bestellingEvents, int nrBestelling, int aantalBroodjes, double totalePrijs){
        for (Observer obs: observerMap.get(bestellingEvents)){
            obs.update(nrBestelling, aantalBroodjes, totalePrijs);
        }
    }

    public void updateBy(BestellingEvents bestellingEvents, int nr_bestelling_extra, int aantal_broodjes_extra, double totalePrijs_extra){
        nr_bestelling += nr_bestelling_extra;
        aantal_broodjes += aantal_broodjes_extra;
        totalePrijs += totalePrijs_extra;
        notifyObservers(bestellingEvents, nr_bestelling, aantal_broodjes, totalePrijs);
    }

    public void addObserverToEvent(BestellingEvents bestellingEvents, Observer obs){
        observerMap.get(bestellingEvents).add(obs);
    }
}
