package services.strategy;

import model.FruitRecord;
import services.FruitDaoService;

public interface OperationsHandler {
    void apply(FruitDaoService daoService, FruitRecord fruitRecord);
}
