package service.strategy.hendlers;

import data.base.Storage;
import model.FruitTransaction;
import service.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer quantity = fruitTransaction.getQuantity();

        Integer currentQuantity = Storage.STORAGE.get(fruit);
        Integer sumOfFruitAfterReturn = Integer.sum(currentQuantity, quantity);

        Storage.STORAGE.put(fruit, sumOfFruitAfterReturn);
    }
}
