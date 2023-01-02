package service.operations;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction) {
        Storage.fruits.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
