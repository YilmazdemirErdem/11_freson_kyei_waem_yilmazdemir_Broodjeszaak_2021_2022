package utilities;

import java.io.*;
import java.util.Collection;
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

    public void save(File file, TreeMap<K,V> treeMap) {
        Collection<V> objecten = treeMap.values();
        String outputLijn = "";
        try {
            PrintWriter writer = new PrintWriter(file);
            for (V object : objecten){
                outputLijn = maakTekstLijn(object);
                writer.println(outputLijn);
            }
        }
        catch (IOException exception){
            System.out.println("fout bij wegschrijven");
        }
    }

    public abstract V maakObject(String[] tokens);

    public abstract K getKey(String[] tokens);

    public abstract String maakTekstLijn(V object);
}