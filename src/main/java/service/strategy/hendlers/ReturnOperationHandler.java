package service.strategy.hendlers;

import data.base.Storage;
import model.FruitTransaction;
import service.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        Integer sumOfFruitAfterReturn = Integer.sum(
                Storage.STORAGE.get(fruitTransaction.getFruit()),
                fruitTransaction.getQuantity());
        Storage.STORAGE.put(fruitTransaction.getFruit(), sumOfFruitAfterReturn);
    }
}
