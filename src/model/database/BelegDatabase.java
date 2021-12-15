package model.database;

import model.BelegSoort;
import model.Broodje;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class BelegDatabase {

    private TreeMap<String, BelegSoort> belegSoortMap;

    public BelegDatabase (){
        // this.belegSoortMap =
    }

    public TreeMap<String, BelegSoort> load(){
        TreeMap<String, BelegSoort> belegSoortMap = new TreeMap<String, BelegSoort>();
        File belegSoortFile = new File("src/bestanden/beleg.txt");
        try {
            Scanner scannerFile = new Scanner(belegSoortFile);
            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] delen = s.split(",");
                String belegNaam = delen[0];
                double belegPrijs = Double.parseDouble(delen[1]);
                int belegStock = Integer.parseInt(delen[2]);
                int aantalBelegVerkocht = Integer.parseInt(delen[3]);
                BelegSoort belegSoort = new BelegSoort(belegNaam, belegPrijs, belegStock, aantalBelegVerkocht);
                belegSoortMap.put(belegNaam, belegSoort);
            }
        }  catch (FileNotFoundException ex) {
            System.out.println("fout bij inlezen");
        }
        catch(NumberFormatException e){
            System.out.println("data niet numeriek");
        }
        return belegSoortMap;
    }
}
