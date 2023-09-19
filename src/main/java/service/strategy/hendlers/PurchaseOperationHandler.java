package service.strategy.hendlers;

import data.base.Storage;
import model.FruitTransaction;
import service.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        int numberToSell = fruitTransaction.getQuantity();
        int numberIsLeft = Storage.STORAGE.get(fruitTransaction.getFruit());
        int numberAfterSelling = numberIsLeft - numberToSell;
        if (numberAfterSelling < 0) {
            throw new RuntimeException("You haven`t fruits to sell.");
        } else {
            Storage.STORAGE.put(fruitTransaction.getFruit(), numberAfterSelling);
        }
    }
}
