package model.database.loadSaveStrategies;

import model.Broodje;
import utilities.TesktLoadSaveTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class BroodjesTekstLoadSaveStrategy extends TesktLoadSaveTemplate implements LoadSaveStrategy {

    @Override
    public TreeMap<String, Broodje> load(){
        TreeMap<String, Broodje>broodjesMap = new TreeMap<String, Broodje>();
        File broodjesFile = new File("src/bestanden/broodjes.txt");
        try {
            Scanner scannerFile = new Scanner(broodjesFile);
            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] delen = s.split(",");
                String broodjesNaam = delen[0];
                double broodjesPrijs = Double.parseDouble(delen[1]);
                int broodjeStock = Integer.parseInt(delen[2]);
                int aantalBroosjesVerkocht = Integer.parseInt(delen[3]);
                Broodje broodje = new Broodje(broodjesNaam, broodjesPrijs, broodjeStock, aantalBroosjesVerkocht);
                broodjesMap.put(broodjesNaam, broodje);
            }
        }  catch (FileNotFoundException ex) {
            System.out.println("fout bij inlezen");
        }
        catch(NumberFormatException e){
            System.out.println("data niet numeriek");
        }
        return broodjesMap;
    }

    @Override
    public void save() {

    }
}
