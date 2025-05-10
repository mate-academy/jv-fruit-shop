package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class TradeOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer valueBeforePurchase = FruitStorage.FRUITS.get(fruit);

        if (valueBeforePurchase == null || valueBeforePurchase < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough " + fruit + " in storage for the transaction");
        }

        Integer valueAfterPurchase = valueBeforePurchase - fruitTransaction.getQuantity();
        FruitStorage.FRUITS.put(fruit, valueAfterPurchase);
    }
}
