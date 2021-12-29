package model.kortingStrategies;

import model.Bestellijn;

import java.util.ArrayList;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class TienProcentKortingOpGanseBestellingKortingStrategy implements KortingStrategy {

    public TienProcentKortingOpGanseBestellingKortingStrategy() {
    }

    @Override
    public double pasKortingToe(double totalePrijs, ArrayList<Bestellijn>bestellijnen) {
        return totalePrijs - totalePrijs*0.1;
    }
}
