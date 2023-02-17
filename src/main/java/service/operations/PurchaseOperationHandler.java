package service.operations;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer lastSumm = Storage.fruits.get(fruitTransaction.getFruitName());
        Storage.fruits.put(fruitTransaction.getFruitName(),
                lastSumm - fruitTransaction.getQuantity());
    }
}
