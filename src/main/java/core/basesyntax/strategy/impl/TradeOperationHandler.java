package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class TradeOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer valueBeforePurchase = FruitStorage.FRUITS.get(fruitTransaction.getFruit());
        Integer valueAfterPurchase = valueBeforePurchase - fruitTransaction.getQuantity();
        FruitStorage.FRUITS.put(fruitTransaction.getFruit(), valueAfterPurchase);
    }
}
