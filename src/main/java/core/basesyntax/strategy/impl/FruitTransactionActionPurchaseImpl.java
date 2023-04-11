package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionAction;

public class FruitTransactionActionPurchaseImpl implements FruitTransactionAction {
    @Override
    public Integer transactionAction(FruitTransaction fruitTransaction) {
        return -fruitTransaction.getQuantity();
    }
}
