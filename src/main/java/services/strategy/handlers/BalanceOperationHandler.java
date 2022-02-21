package services.strategy.handlers;

import model.FruitRecord;
import services.FruitDaoService;
import services.strategy.OperationsHandler;

public class BalanceOperationHandler implements OperationsHandler {
    @Override
    public void apply(FruitDaoService daoService, FruitRecord fruitRecord) {
        daoService.save(fruitRecord);
    }
}
