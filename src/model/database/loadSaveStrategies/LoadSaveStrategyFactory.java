package model.database.loadSaveStrategies;

public class LoadSaveStrategyFactory {

    public LoadSaveStrategy createBroodjesLoadSaveStrategy(LoadSaveStrategyEnum loadSaveStrategyEnum){
        if (loadSaveStrategyEnum == LoadSaveStrategyEnum.EXCEL){
            return BroodjesExcelLoadSaveStrategy;
        } else {
            return BroodjesTekstLoadSaveStrategy;
        }
    }
}
