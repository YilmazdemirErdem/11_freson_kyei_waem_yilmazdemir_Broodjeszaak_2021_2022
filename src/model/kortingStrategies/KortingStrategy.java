package model.kortingStrategies;

import model.Bestellijn;
import model.Bestelling;

import java.util.ArrayList;

public interface KortingStrategy {
    double pasKortingToe(double totalePrijs, ArrayList<Bestellijn>bestellijnen);
}
