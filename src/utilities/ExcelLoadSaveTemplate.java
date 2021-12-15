package utilities;

import java.util.TreeMap;

public abstract class ExcelLoadSaveTemplate {

    public abstract TreeMap<String, Object> load();

    public abstract void save();
}
