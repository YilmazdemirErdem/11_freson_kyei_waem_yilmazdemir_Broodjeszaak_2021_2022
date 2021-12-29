package model.database.loadSaveStrategies;

import java.io.File;
import java.util.TreeMap;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public interface LoadSaveStrategy {

    TreeMap load(File file);
    void save(File file, TreeMap treeMap);
}
