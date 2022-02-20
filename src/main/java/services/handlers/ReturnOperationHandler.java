package services.handlers;

import model.FruitRecord;
import services.FruitDaoService;
import services.OperationsHandler;

public class ReturnOperationHandler implements OperationsHandler {
    @Override
    public void apply(FruitDaoService daoService, FruitRecord fruitRecord) {
        daoService.put(fruitRecord);
    }
}
