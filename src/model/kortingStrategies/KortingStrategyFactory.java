package model.kortingStrategies;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class KortingStrategyFactory {

    private static KortingStrategyFactory instance = new KortingStrategyFactory();
    private static KortingStrategy tienProcentKortingOpGanseBestellingKortingStrategy = new TienProcentKortingOpGanseBestellingKortingStrategy();
    private static KortingStrategy goedkoopsteBroodjeBelegGratisKortingStrategy = new GoedkoopsteBroodjeBelegGratisKortingStrategy();

    private KortingStrategyFactory() {}

    public static KortingStrategyFactory getInstance(){
        return instance;
    }

    public KortingStrategy createKortingStrategy(KortingStrategyEnum kortingStrategyEnum){
        if (kortingStrategyEnum == KortingStrategyEnum.TIEN_PROCENT_OP_GANSE_BESTELLING){
            return tienProcentKortingOpGanseBestellingKortingStrategy;
        } else {
            return goedkoopsteBroodjeBelegGratisKortingStrategy;
        }
    }
}
