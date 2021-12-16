package model;

import model.database.BroodjesDatabase;
import utilities.Observer;

import java.util.ArrayList;
import java.util.HashMap;

public class BestelFacade implements Subject {
    private int nr_bestelling = 1;
    private int aantal_broodjes = 0;
    private HashMap<BestellingEvents, ArrayList<Observer>> observerMap = new HashMap<>();
    private BroodjesDatabase broodjesDatabase;
    private Bestelling bestelling;

    public BestelFacade() {
        initiateObserverMap();
    }

    private void initiateObserverMap() {
        for (BestellingEvents bestellingEvents : BestellingEvents.values()) {
            this.observerMap.put(bestellingEvents, new ArrayList<Observer>());
        }
    }

    public void toevoegenBroodje(String broodjesNaam){
        Broodje broodje = broodjesDatabase.getBroodje(broodjesNaam);
        bestelling.toevoegenBroodje(broodje);
    }

    public void voegBestellijnToe(String broodjesNaam){

    }

    public void getLijstBestellijnen(){
        bestelling.getBestellijen();
    }

    public void getVoorraadLijstBroodjes(){

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
