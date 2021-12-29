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
    private int aantalInWachtrij = 0;

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
    public void update(int nrBestelling, int aantalBroodjes, double totalePrijs, int aantalBestellingenInWachtrij) {
        System.out.println("aantalBestellingenInWachtrij: " + aantalBestellingenInWachtrij);
        aantalInWachtrij = aantalBestellingenInWachtrij;
        keukenView.setLabelAantalBestellingenInWachtrij("Aantal bestellingen in de wachtrij: " + aantalBestellingenInWachtrij);
        keukenView.setLabelAantalBroodjes("Aantal broodjes: " + aantalBroodjes);
        keukenView.setLabelVolgnr("Volgnummer bestelling: " + nrBestelling);
        if (aantalBestellingenInWachtrij == 1) {
            keukenView.updateBestellijnen(this);
        }
        if (aantalBestellingenInWachtrij > 0) {
            keukenView.enableVolgendeKnop(false);
        } else if (aantalBestellingenInWachtrij == 0) {
            keukenView.enableAfgewerktKnop(false);
        }
    }

    public void volgendeKnopPressed() {
        if (bestelFacade.getKeukenBestellingen().size() == 0) {
            keukenView.showAlert("Gaat niet!", "Er zitten geen bestellingen in de wachtrij.");
        } else {
            //TODO: Indien men klikt op de “Volgende bestelling” knop wordt de eerst toegevoegde bestelling uit de wachtrij verwijderd en getoond.
            bestelFacade.getKeukenBestellingen().remove(0);
            keukenView.updateBestellijnen(this);
            bestelFacade.updateBy(BestellingEvents.VERWIJDER_BROODJE, 0,0, aantalInWachtrij-1); //TODO: klopt dit??
        }
    }

    public void afgewerktKnopPressed() {
        //TODO: ??
        if ( bestelFacade.getKeukenBestellingen().size() > 0 ) {
            keukenView.showAlert("Gaat niet!", "Er zitten nog bestellingen in de wachtrij.");
        } else {
            bestelFacade.updateBy(BestellingEvents.AFGEWERKT, 0, 0, aantalInWachtrij);
        }
    }
    public ArrayList<Bestellijn> getLijstBestellijnen(){
        return bestelFacade.getLijstBestellijnen();
    }
}
