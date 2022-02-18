package shop.strategy;

import shop.db.Storage;
import shop.impl.FruitTransaction;
import shop.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        int fruitAmount = fruitTransaction.getQuantity();
        Storage.fruitsCount.put(new Fruit(fruitTransaction.getFruitName()), fruitAmount);
    }
}
