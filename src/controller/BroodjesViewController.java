package controller;

import model.BestelFacade;
import model.BestellingEvents;
import utilities.Observer;
import view.panels.BroodjesBelegOverviewPane;

public class BroodjesViewController implements Observer {

    private BroodjesBelegOverviewPane broodjesBelegOverviewPane;
    private BestelFacade bestelFacade;

    public BroodjesViewController(BestelFacade bestelFacade){
        setBestelFacade(bestelFacade);
        bestelFacade.addObserverToEvent(BestellingEvents.NAAR_KEUKEN,this);
    }

    public void setBestelFacade(BestelFacade bestelFacade) {
        this.bestelFacade = bestelFacade;
    }

    @Override
    public void update(int nrBestelling, int aantalBroodjes, double totalePrijs, int aantalBroodjesInWachtrij) {

    }
}
