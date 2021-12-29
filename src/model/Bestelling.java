package model;

import model.bestelStates.*;

import java.util.ArrayList;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

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

    public void nieuweBestelling(Bestelling bestelling) {
       bestellingState.maakNieuweBestelling(bestelling);
    }

    public void toevoegenBroodje(Broodje broodje){
        bestellingState.voegBestellijnToe(broodje);
    }

    public void toevoegenBeleg(Bestellijn bestellijn, BelegSoort belegSoort) {
        bestellingState.voegBelegToe(bestellijn, belegSoort);
    }

    public void voegDezelfdeBestellijnToe(Bestellijn bestellijn) {
        bestellingState.voegIdentiekBroodjeToe(bestellijn);
    }

    public void verwijderBestellijn(Bestellijn bestellijn) {
        bestellingState.verwijderBroodje(bestellijn);
    }

    public Double berekenTotaalBedrag(String kortingsStrategie) {
        return bestellingState.afsluiten(kortingsStrategie);
    }

    public void annuleer(Bestelling bestelling){
        bestellingState.annuleren(bestelling);
    }

    public void betalen() {
        bestellingState.betalen();
    }

    public void naarKeuken(ArrayList<Bestelling> wachtrij, Bestelling bestelling) {
        bestellingState.naar_keuken(wachtrij, bestelling);
    }
}
