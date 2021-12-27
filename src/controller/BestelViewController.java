package controller;

import javafx.scene.control.Alert;
import model.*;
import utilities.Observer;
import view.BestelView;

import java.util.ArrayList;
import java.util.HashMap;

public class BestelViewController implements Observer {
    private BestelView bestelView;
    private BestelFacade bestelFacade;

    public BestelViewController(BestelFacade bestelFacade) {
        setBestelFacade(bestelFacade);
        bestelFacade.addObserverToEvent(BestellingEvents.IN_WACHT, this);
        bestelFacade.addObserverToEvent(BestellingEvents.IN_BESTELLING, this);
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
        //bestelFacade.changeState(BestellingEvents.IN_BESTELLING);
        bestelFacade.updateBy(BestellingEvents.IN_BESTELLING, 1,0, 0);
    }

    public void broodjeButtonPressed(Broodje broodje) {
        bestelFacade.toevoegenBroodje(broodje);
        bestelView.updateBestelijnen(this);
        bestelFacade.updateBy(BestellingEvents.IN_BESTELLING, 0, 1, 0);
    }

    public void belegButtonPressed(BelegSoort belegSoort) {
        Bestellijn bestellijn = bestelView.getSelectedBestellijn();
        if(bestellijn == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Onbestaand broodje");
            alert.setContentText("Je kan geen beleg toevoegen zonder een broodje geselecteerd te hebben!");

            alert.showAndWait();
        }else{
            bestelFacade.toevoegenBeleg(bestellijn, belegSoort);
            bestelView.updateBestelijnen(this);
            bestelFacade.updateBy(BestellingEvents.IN_BESTELLING, 0, 0, 0);
        }
    }

    public void voegZelfdeBroodjeToeButtonPressed() {
        Bestellijn bestellijn = bestelView.getSelectedBestellijn();
        if(bestellijn == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Onbestaande bestellijn");
            alert.setContentText("Je kan geen bestellijn kopiëren toevoegen zonder een bestellijn geselecteerd te hebben!");

            alert.showAndWait();
        }else{
            bestelFacade.voegZelfdeToe(bestellijn);
            bestelView.updateBestelijnen(this);
        }
    }

    public void VerwijderBroodjeButtonPressed() {
        Bestellijn bestellijn = bestelView.getSelectedBestellijn();
        bestelFacade.verwijderBestellijn(bestellijn);
        bestelView.updateBestelijnen(this);
    }

    public void afsluitenBetalingButtonPressed() {
        bestelFacade.berekenTotaalBedrag(bestelView.getkortingsStrategie());
    }

    //called by view
    public void setView(BestelView view) {
        this.bestelView = view;
    }

    //called by model
    @Override
    public void update(int nrBestelling, int aantalBroodjes, double totalePrijs) {
        bestelView.setLabelAantalBestellingen("Volgnr: " + nrBestelling);
        bestelView.setLabelAantalBroodjes("Aantal Broodjes: " + aantalBroodjes);
        bestelView.setLabelTeBetalen("Te betalen: " + totalePrijs);
    }
}
