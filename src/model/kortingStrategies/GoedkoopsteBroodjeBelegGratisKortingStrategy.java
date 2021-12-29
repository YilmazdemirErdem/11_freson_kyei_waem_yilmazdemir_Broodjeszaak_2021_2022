package model.kortingStrategies;

import model.Bestellijn;

import java.util.ArrayList;

public class GoedkoopsteBroodjeBelegGratisKortingStrategy implements KortingStrategy{

    public GoedkoopsteBroodjeBelegGratisKortingStrategy() {
    }

    @Override
    public double pasKortingToe(double totalePrijs, ArrayList<Bestellijn>bestellijnen) {
        double goedkoopste = Double.MAX_VALUE;
        for (Bestellijn bestellijn:bestellijnen) {
            if (bestellijn.getPrijsBestellijn() < goedkoopste){
                goedkoopste = bestellijn.getPrijsBestellijn();
            }
        }

        return totalePrijs - goedkoopste;
    }
}
