package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public abstract class TekstLoadSaveTemplate<K,V>{

    public TreeMap<K,V> load(File file) {
        TreeMap<K,V> returnMap = new TreeMap<K,V>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                String[] tokens = line.split(",");
                V element = maakObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key,element);
                line = reader.readLine();
            }
        } catch (IOException exception) {
            System.out.println("fout bij inlezen");
        }
        return returnMap;
    }

    public void save() {

    }

    public abstract V maakObject(String[] tokens);

    public abstract K getKey(String[] tokens);


}