package utilities;

import excel.ExcelPlugin;
import java.io.File;
import java.util.ArrayList;
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

    public void save(){

    };

    public abstract V maakObject(String[] tokens);

    public abstract K getKey(String[] tokens);
}
