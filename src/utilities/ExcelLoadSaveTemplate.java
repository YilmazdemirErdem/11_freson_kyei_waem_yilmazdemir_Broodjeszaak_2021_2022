package utilities;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

public abstract class ExcelLoadSaveTemplate<K,V>{

    public TreeMap<K, V> load(File file){
        ExcelPlugin excelPlugin = new ExcelPlugin();
        TreeMap<K,V> returnMap = new TreeMap<K,V>();
        ArrayList<ArrayList<String>> input;
        try {
            input = excelPlugin.read(file);
            String [] tokens = null;
            for (ArrayList<String> lijn: input){
                tokens = new String[lijn.size()];
                for (int i=0; i<lijn.size();i++){
                    tokens[i] = lijn.get(i);
                }
                V element = maakObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key, element);
            }

        } catch (Exception exception){
            System.out.println("fout bij inlezen");
        }
        return returnMap;
    }

    public void save(File file, TreeMap<K,V> treeMap) {
        ExcelPlugin excelPlugin = new ExcelPlugin();
        Collection<V> objecten = treeMap.values();
        ArrayList<ArrayList<String>> outputLijnen = new ArrayList<>();
        try {
            for (V object : objecten) {
                ArrayList<String> outputLijn;
                outputLijn = maaktTekstLijn(object);
                outputLijnen.add(outputLijn);
            }
            excelPlugin.write(file, outputLijnen);
        } catch (Exception exception) {
            System.out.println("fout bij wegschrijven");
        }
    }

    public abstract V maakObject(String[] tokens);

    public abstract K getKey(String[] tokens);

    public abstract ArrayList<String> maaktTekstLijn(V object);
}
