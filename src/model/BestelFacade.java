package model;

import javafx.collections.ObservableList;
import model.database.BelegDatabase;
import model.database.BroodjesDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import utilities.Observer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class BestelFacade implements Subject {
    private int nr_bestelling = 0;
    private int aantal_broodjes = 0;
    private double totalePrijs = 0.0;
    private int aantalBestellingenInWachtrij = 0;
    private ArrayList<ObservableList> keukenBestellingen = new ArrayList<>();
    private HashMap<BestellingEvents, ArrayList<Observer>> observerMap = new HashMap<>();
    private BroodjesDatabase broodjesDatabase = new BroodjesDatabase(LoadSaveStrategyEnum.TEKST);
    private BelegDatabase belegDatabase = new BelegDatabase(LoadSaveStrategyEnum.TEKST);
    private ArrayList<Bestelling> wachtrij = new ArrayList<>();
    private Bestelling bestelling;

    public BestelFacade() {
        initiateObserverMap();
        setBestelling();
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling() {
        this.bestelling = new Bestelling();
    }

    private void initiateObserverMap() {
        for (BestellingEvents bestellingEvents : BestellingEvents.values()) {
            this.observerMap.put(bestellingEvents, new ArrayList<Observer>());
        }
    }

    public void nieuweBestelling() {
        this.setBestelling();
        bestelling.nieuweBestelling(bestelling);
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
        bestelling.voegDezelfdeBestellijnToe(bestellijn);
    }

    public void verwijderBestellijn(Bestellijn bestellijn) {
        bestelling.verwijderBestellijn(bestellijn);
    }

    public void annuleerBestelling() {
        this.totalePrijs = 0.0;
        this.bestelling.annuleer(this.bestelling);
    }

    public void berekenTotaalBedrag(String kortingsStrategie) {
        totalePrijs = bestelling.berekenTotaalBedrag(kortingsStrategie);
    }

    public int getAantalInWachtrij() {
        return aantalBestellingenInWachtrij;
    }

    public void betaalBestelling() {
        bestelling.betalen();
    }

    public void zendNaarKeuken(ObservableList items) {
        bestelling.naarKeuken(wachtrij, bestelling, broodjesDatabase);
        //TODO: hier iets aanpassen?
        keukenBestellingen.add(items);
    }

    public ArrayList<ObservableList> getKeukenBestellingen() {
        return this.keukenBestellingen;
    }

    public void notifyObservers(BestellingEvents bestellingEvents, int nrBestelling, int aantalBroodjes, double totalePrijs, int aantalBroodjesInWachtrij){
        for (Observer obs: observerMap.get(bestellingEvents)){
            obs.update(nrBestelling, aantalBroodjes, totalePrijs, aantalBroodjesInWachtrij);
        }
    }

    public void updateBy(BestellingEvents bestellingEvents, int nr_bestelling_extra, int aantal_broodjes_extra, int extra_inWachtrij){
        nr_bestelling += nr_bestelling_extra;
        aantal_broodjes += aantal_broodjes_extra;
        aantalBestellingenInWachtrij += extra_inWachtrij;
        notifyObservers(bestellingEvents, nr_bestelling, aantal_broodjes, totalePrijs, aantalBestellingenInWachtrij);
    }

    public void addObserverToEvent(BestellingEvents bestellingEvents, Observer obs){
        observerMap.get(bestellingEvents).add(obs);
    }
}
