package service.strategy.hendlers;

import data.base.Storage;
import model.FruitTransaction;
import service.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer quantity = fruitTransaction.getQuantity();

        Integer currentQuantity = Storage.STORAGE.get(fruit);
        Integer sumOfFruitAfterSupply = Integer.sum(currentQuantity, quantity);

        Storage.STORAGE.put(fruit, sumOfFruitAfterSupply);
    }
}
