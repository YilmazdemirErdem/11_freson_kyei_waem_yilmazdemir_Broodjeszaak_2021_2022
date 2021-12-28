package controller;

import model.*;
import utilities.Observer;
import view.BestelView;

import java.util.ArrayList;

public class BestelViewController implements Observer {
    private BestelView bestelView;
    private BestelFacade bestelFacade;

    public BestelViewController(BestelFacade bestelFacade) {
        setBestelFacade(bestelFacade);
        bestelFacade.addObserverToEvent(BestellingEvents.NIEUWE_BESTELLING, this);
        bestelFacade.addObserverToEvent(BestellingEvents.TOEVOEGEN_BROODJE, this);
        bestelFacade.addObserverToEvent(BestellingEvents.TOEVOEGEN_BELEG, this);
        bestelFacade.addObserverToEvent(BestellingEvents.VERWIJDER_BROODJE, this);
        bestelFacade.addObserverToEvent(BestellingEvents.TOEVOEGEN_IDENTIEK_BROODJE, this);
        bestelFacade.addObserverToEvent(BestellingEvents.AFSLUITEN, this);
        bestelFacade.addObserverToEvent(BestellingEvents.ANNULEREN, this);
        bestelFacade.addObserverToEvent(BestellingEvents.NAAR_KEUKEN, this);
        bestelFacade.addObserverToEvent(BestellingEvents.AFGEWERKT, this);
        bestelFacade.addObserverToEvent(BestellingEvents.BETALEN, this);
        bestelFacade.addObserverToEvent(BestellingEvents.START_BEREIDING, this);
    }

    public BestelFacade getBestelFacade() {
        return bestelFacade;
    }

    public void setBestelFacade(BestelFacade bestelFacade) {
        this.bestelFacade = bestelFacade;
    }

    public ArrayList<Broodje> getOpVoorraadLijstBroodjes() {
        return bestelFacade.getOpVoorraadLijstBroodjes();
    }

    public ArrayList<BelegSoort> getOpVoorraadLijstBelegSoorten() {
        return bestelFacade.getOpVoorraadLijstBelegSoorten();
    }

    public void toevoegenBroodje(Broodje broodje){
        bestelFacade.toevoegenBroodje(broodje);
    }

    public ArrayList<Bestellijn> getLijstBestellijnen(){
        return bestelFacade.getLijstBestellijnen();
    }

    public void nieuweBestellingButtonPressed() {
        bestelFacade.nieuweBestelling();
        bestelFacade.updateBy(BestellingEvents.NIEUWE_BESTELLING, 1,0, 0);
        bestelView.updateStatusInBestellingKnoppen(false);
    }

    public void broodjeButtonPressed(Broodje broodje) {
        bestelFacade.toevoegenBroodje(broodje);
        bestelView.updateBestelijnen(this);
        bestelView.updateBroodjesStatusKnoppen(this);
        bestelFacade.updateBy(BestellingEvents.TOEVOEGEN_BROODJE, 0, 1, 0);
    }

    public void belegButtonPressed(BelegSoort belegSoort) {
        Bestellijn bestellijn = bestelView.getSelectedBestellijn();
        if(bestellijn == null){
            bestelView.foutMelding("Onbestaand broodje", "Je kan geen beleg toevoegen zonder een broodje geselecteerd te hebben!");
        }else{
            bestelFacade.toevoegenBeleg(bestellijn, belegSoort);
            bestelView.updateBestelijnen(this);
            bestelFacade.updateBy(BestellingEvents.TOEVOEGEN_BELEG, 0, 0, 0);
        }
    }

    public void voegZelfdeBroodjeToeButtonPressed() {
        Bestellijn bestellijn = bestelView.getSelectedBestellijn();
        if(bestellijn == null){
            bestelView.foutMelding("Onbestaande bestellijn", "Je kan geen bestellijn kopiëren of toevoegen zonder een bestellijn geselecteerd te hebben!");
        }else{
            bestelFacade.voegZelfdeToe(bestellijn);
            bestelView.updateBestelijnen(this);
            bestelFacade.updateBy(BestellingEvents.TOEVOEGEN_IDENTIEK_BROODJE, 0, 1, 0);
        }
    }

    public void VerwijderBroodjeButtonPressed() {
        Bestellijn bestellijn = bestelView.getSelectedBestellijn();
        if(bestellijn == null){
            bestelView.foutMelding("Onbestaande bestellijn", "Je kan geen bestellijn verwijderen zonder een bestellijn geselecteerd te hebben!");
        }else{
            bestelFacade.verwijderBestellijn(bestellijn);
            bestelView.updateBestelijnen(this);
            bestelFacade.updateBy(BestellingEvents.VERWIJDER_BROODJE, 0, -1, 0);
        }
    }

    public void annuleerBestelling() {
        bestelFacade.annuleerBestelling();
        bestelView.updateBestelijnen(this);
        bestelFacade.updateBy(BestellingEvents.ANNULEREN, 0,0,0);
        bestelView.updateStatusInWachtKnoppen(false);
    }

    public void afsluitenBetalingButtonPressed() {
        bestelFacade.berekenTotaalBedrag(bestelView.getkortingsStrategie());
        bestelFacade.updateBy(BestellingEvents.AFSLUITEN, 0, 0, 0);
        bestelView.updateStatusInAfgeslotenKnoppen(false);
    }

    public void betaalBestelling() {
        bestelFacade.betaalBestelling();
        bestelView.updateStatusInBetaaldKnoppen(false);
    }

    public void zendNaarKeukenBestelling() {
        bestelFacade.zendNaarKeuken();
        bestelFacade.updateBy(BestellingEvents.NAAR_KEUKEN, 0,0, 1);
        bestelView.updateStatusInWachtKnoppen(false);
    }

    //called by view
    public void setView(BestelView view) {
        this.bestelView = view;
    }

    //called by model
    @Override
    public void update(int nrBestelling, int aantalBroodjes, double totalePrijs, int aantalBroodjesInWachtrij) {
        bestelView.setLabelAantalBestellingen("Volgnr: " + nrBestelling);
        bestelView.setLabelAantalBroodjes("Aantal Broodjes: " + aantalBroodjes);
        bestelView.setLabelTeBetalen("Te betalen: " + totalePrijs + "$");
    }
}
