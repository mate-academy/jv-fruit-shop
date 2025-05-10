package service.operation;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        Storage.remove(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
