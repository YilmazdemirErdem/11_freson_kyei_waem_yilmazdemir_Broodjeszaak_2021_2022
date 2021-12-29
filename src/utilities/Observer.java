package utilities;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public interface Observer {

    void update(int nrBestelling, int aantalBroodjes, double totalePrijs, int aantalBroodjesInWachtrij);
}
