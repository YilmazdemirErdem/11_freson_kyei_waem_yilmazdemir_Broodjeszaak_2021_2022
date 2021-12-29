package model.kortingStrategies;

import model.Bestellijn;

import java.util.ArrayList;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

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
