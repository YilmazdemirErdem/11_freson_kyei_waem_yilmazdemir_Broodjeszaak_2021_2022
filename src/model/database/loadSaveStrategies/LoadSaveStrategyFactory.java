package model.database.loadSaveStrategies;

public class LoadSaveStrategyFactory {

    private LoadSaveStrategy broodjesExcelLoadSaveStrategy = new BroodjesExcelLoadSaveStrategy();
    private LoadSaveStrategy broodjesTekstLoadSaveStrategy = new BroodjesTekstLoadSaveStrategy();
    private LoadSaveStrategy belegSoortExcelLoadSaveStrategy = new BelegSoortExcelLoadSaveStrategy();
    private LoadSaveStrategy belegSoortTekstLoadSaveStrategy = new BelegSoortTekstLoadSaveStrategy();

    public LoadSaveStrategyFactory() {}

    public LoadSaveStrategy createBroodjesLoadSaveStrategy(LoadSaveStrategyEnum loadSaveStrategyEnum){
        if (loadSaveStrategyEnum == LoadSaveStrategyEnum.EXCEL){
            return broodjesExcelLoadSaveStrategy;
        } else {
            return broodjesTekstLoadSaveStrategy;
        }
    }

    public LoadSaveStrategy createBelegSoortLoadSaveStrategy(LoadSaveStrategyEnum loadSaveStrategyEnum){
        if (loadSaveStrategyEnum == LoadSaveStrategyEnum.EXCEL){
            return belegSoortExcelLoadSaveStrategy;
        } else {
            return belegSoortTekstLoadSaveStrategy;
        }
    }
}
