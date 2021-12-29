package model.kortingStrategies;

import model.Bestellijn;

import java.util.ArrayList;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public interface KortingStrategy {
    double pasKortingToe(double totalePrijs, ArrayList<Bestellijn>bestellijnen);
}
