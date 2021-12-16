package model.database.loadSaveStrategies;

import java.io.File;
import java.util.TreeMap;

public interface LoadSaveStrategy {

    TreeMap load(File file);
    void save(File file, TreeMap treeMap);
}
