package service.operations;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
