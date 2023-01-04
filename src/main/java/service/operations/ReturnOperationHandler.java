package service.operations;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruitName(),
                Storage.fruits.get(fruitTransaction.getFruitName())
                + fruitTransaction.getQuantity());
    }
}
