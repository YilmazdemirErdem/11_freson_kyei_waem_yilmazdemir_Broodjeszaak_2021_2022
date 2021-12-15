package model.database.loadSaveStrategies;

import java.util.TreeMap;

public interface LoadSaveStrategy {

    TreeMap load();
    void save();
}
