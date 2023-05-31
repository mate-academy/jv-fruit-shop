package service.operation;

import db.Storage;
import exception.NegativeQuantityException;
import models.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldQuantity = Storage.fruitMap.getOrDefault(fruitTransaction.getFruit(), 0);
        if (oldQuantity - fruitTransaction.getQuantity() < 0) {
            throw new NegativeQuantityException(
                "Insufficient quantity of fruits in storage to buy");
        }
        Storage.fruitMap.put(fruitTransaction.getFruit(),
                oldQuantity - fruitTransaction.getQuantity());
    }
}
