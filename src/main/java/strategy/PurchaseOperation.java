package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = Storage.fruitsStorage.get(fruit);
        int quantityToBuy = fruitTransaction.getQuantity();
        if (quantityToBuy > quantity) {
            throw new RuntimeException("Can't do this operation, don't have enough fruits");
        }
        Storage.fruitsStorage.put(fruit,quantity - quantityToBuy);
    }
}
