package controller;

import model.*;
import utilities.Observer;
import view.BestelView;
import view.KeukenView;

import java.util.ArrayList;

public class KeukenViewController implements Observer {
    private KeukenView keukenView;
    private BestelFacade bestelFacade;
    private ArrayList<Bestelling> wachtrij; // of BestelLijn

    public KeukenViewController(BestelFacade bestelFacade) {
        setBestelFacade(bestelFacade);
        bestelFacade.addObserverToEvent(BestellingEvents.NAAR_KEUKEN, this);
        wachtrij = new ArrayList<>();
    }

    public BestelFacade getBestelFacade() {
        return bestelFacade;
    }

    public void setBestelFacade(BestelFacade bestelFacade) {
        this.bestelFacade = bestelFacade;
    }

    //called by view
    public void setView(KeukenView view) {
        this.keukenView = view;
    }

    //called by model
    @Override
    public void update(int nrBestelling, int aantalBroodjes, double totalePrijs, int aantalBroodjesInWachtrij) {
        keukenView.setLabelAantalBestellingenInWachtrij("Aantal bestellingen in de wachtrij: " + aantalBroodjesInWachtrij);
        keukenView.setLabelAantalBroodjes("Aantal broodjes: " + aantalBroodjes);
        keukenView.setLabelVolgnr("Volgnummer bestelling: " + nrBestelling);
    }

    public void volgendeKnopPressed() {
        //TODO: Indien men klikt op de “Volgende bestelling” knop wordt de eerst toegevoegde bestelling uit de wachtrij verwijderd en getoond.
        wachtrij.remove(0); //?? & tonen
    }

    public void afgewerktKnopPressed() {
        //TODO: ??
    }
}
