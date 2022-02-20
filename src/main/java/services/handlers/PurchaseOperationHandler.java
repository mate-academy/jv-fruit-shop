package services.handlers;

import model.FruitRecord;
import services.FruitDaoService;
import services.OperationsHandler;

public class PurchaseOperationHandler implements OperationsHandler {
    @Override
    public void apply(FruitDaoService daoService, FruitRecord fruitRecord) {
        fruitRecord.setAmount(fruitRecord.getAmount() * (-1));
        daoService.put(fruitRecord);
    }
}
