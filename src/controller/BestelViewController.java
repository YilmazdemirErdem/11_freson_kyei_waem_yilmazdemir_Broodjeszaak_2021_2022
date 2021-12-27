package controller;

import model.BelegSoort;
import model.BestelFacade;
import model.BestellingEvents;
import model.Broodje;
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

    public HashMap<Broodje, ArrayList<BelegSoort>> getLijstBestellijnen(){
        return bestelFacade.getLijstBestellijnen();
    }

    public void nieuweBestellingButtonPressed() {
        //bestelFacade.changeState(BestellingEvents.IN_BESTELLING);
        bestelFacade.updateBy(BestellingEvents.IN_BESTELLING, 1,0);
    }

    public void broodjeButtonPressed(Broodje broodje) {
        bestelFacade.toevoegenBroodje(broodje);
        bestelFacade.updateBy(BestellingEvents.IN_BESTELLING, 0, 1);
    }

    public void belegButtonPressed(BelegSoort belegSoort) {
        bestelFacade.updateBy(BestellingEvents.IN_BESTELLING, 0, 0);
    }

    //called by view
    public void setView(BestelView view) {
        this.bestelView = view;
    }

    //called by model
    @Override
    public void update(int nrBestelling, int aantalBroodjes) {
        bestelView.setLabelAantalBestellingen("Volgnr: " + nrBestelling);
        bestelView.setLabelAantalBroodjes("Aantal Broodjes: " + aantalBroodjes);
    }
}
