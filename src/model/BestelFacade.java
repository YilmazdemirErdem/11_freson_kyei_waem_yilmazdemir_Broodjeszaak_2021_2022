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
    private BestellingState bestellingState;
    private HashMap<BestellingEvents, ArrayList<Observer>> observerMap = new HashMap<>();
    private BroodjesDatabase broodjesDatabase = new BroodjesDatabase(LoadSaveStrategyEnum.TEKST);
    private BelegDatabase belegDatabase = new BelegDatabase(LoadSaveStrategyEnum.TEKST);
    private Bestelling bestelling;

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

    public void toevoegenBroodje(String broodjesNaam){
        Broodje broodje = broodjesDatabase.getBroodje(broodjesNaam);
        bestelling.toevoegenBroodje(broodje);
    }

    public void voegBestellijnToe(String broodjesNaam){

    }

    public HashMap<Broodje, ArrayList<BelegSoort>> getLijstBestellijnen(){
        return bestelling.getBestellijnen();
    }

    public ArrayList<String> getOpVoorraadLijstBroodjes(){
        return broodjesDatabase.getOpVoorraadLijstBroodjes();
    }

    public ArrayList<String> getOpVoorraadLijstBelegSoorten() {
        return belegDatabase.getOpVoorraadLijstBelegSoorten();
    }

    public void notifyObservers(BestellingEvents bestellingEvents, int nrBestelling, int aantalBroodjes){
        for (Observer obs: observerMap.get(bestellingEvents)){
            obs.update(nrBestelling, aantalBroodjes);
        }
    }

    public void updateBy(BestellingEvents bestellingEvents, int nr_bestelling_extra, int aantal_broodjes_extra){
        nr_bestelling += nr_bestelling_extra;
        aantal_broodjes += aantal_broodjes_extra;
        notifyObservers(bestellingEvents, nr_bestelling, aantal_broodjes);
    }

    public void addObserverToEvent(BestellingEvents bestellingEvents, Observer obs){
        observerMap.get(bestellingEvents).add(obs);
    }
}
