package controller;

import model.BestelFacade;
import model.BestellingEvents;
import utilities.Observer;
import view.AdminMainPane;
import view.AdminView;
import view.BestelView;
import view.panels.BroodjesBelegOverviewPane;
import view.panels.BroodjesPane;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class BroodjesViewController implements Observer {

    private AdminView adminView;
    private BestelFacade bestelFacade;

    public BroodjesViewController(BestelFacade bestelFacade){
        setBestelFacade(bestelFacade);
        bestelFacade.addObserverToEvent(BestellingEvents.NAAR_KEUKEN,this);
    }

    public void setBestelFacade(BestelFacade bestelFacade) {
        this.bestelFacade = bestelFacade;
    }

    public void setView(AdminView view) {
        this.adminView = view;
    }

    @Override
    public void update(int nrBestelling, int aantalBroodjes, double totalePrijs, int aantalBroodjesInWachtrij) {
        adminView.refresh();
    }
}
