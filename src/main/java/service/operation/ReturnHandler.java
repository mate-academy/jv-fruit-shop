package service.operation;

import db.Storage;
import models.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldQuantity = Storage.fruitMap.get(fruitTransaction.getFruit());
        Storage.fruitMap.put(fruitTransaction.getFruit(),
                oldQuantity + fruitTransaction.getQuantity());
    }
}
