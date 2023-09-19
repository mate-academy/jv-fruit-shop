package service.strategy.hendlers;

import data.base.Storage;
import model.FruitTransaction;
import service.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        Integer startNumberOfFruit = fruitTransaction.getQuantity();
        Storage.STORAGE.put(fruitTransaction.getFruit(), startNumberOfFruit);
    }
}
