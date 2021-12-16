package controller;

import model.BestelFacade;
import model.BestellingEvents;
import utilities.Observer;
import view.BestelView;

public class BestelViewController implements Observer {
    private BestelView bestelView;
    private BestelFacade bestelFacade;

    public BestelViewController(BestelFacade bestelFacade) {
        setBestelFacade(bestelFacade);
        bestelFacade.addObserverToEvent(BestellingEvents.TOEVOEGEN_BROODJE, this);
    }

    public BestelFacade getBestelFacade() {
        return bestelFacade;
    }

    public void setBestelFacade(BestelFacade bestelFacade) {
        this.bestelFacade = bestelFacade;
    }

    public void toevoegenBroodje(String broodjesNaam){
        bestelFacade.toevoegenBroodje(broodjesNaam);
    }

    public void getLijstBestellijnen(){
        bestelFacade.getLijstBestellijnen();
        //update();
    }
    public void maisButtonPressed() {
        bestelFacade.updateBy(BestellingEvents.TOEVOEGEN_BROODJE, 0, 1);
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
