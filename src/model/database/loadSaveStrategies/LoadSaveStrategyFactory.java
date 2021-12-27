package model.database.loadSaveStrategies;

public class LoadSaveStrategyFactory {

    private static LoadSaveStrategyFactory instance = new LoadSaveStrategyFactory();
    private static LoadSaveStrategy broodjesExcelLoadSaveStrategy = new BroodjesExcelLoadSaveStrategy();
    private static LoadSaveStrategy broodjesTekstLoadSaveStrategy = new BroodjesTekstLoadSaveStrategy();
    private static LoadSaveStrategy belegSoortExcelLoadSaveStrategy = new BelegSoortExcelLoadSaveStrategy();
    private static LoadSaveStrategy belegSoortTekstLoadSaveStrategy = new BelegSoortTekstLoadSaveStrategy();

    private LoadSaveStrategyFactory() {}

    public static LoadSaveStrategyFactory getInstance(){
        return instance;
    }

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
