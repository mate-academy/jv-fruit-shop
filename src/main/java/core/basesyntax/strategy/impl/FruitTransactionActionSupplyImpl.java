package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;

public class FruitTransactionActionSupplyImpl
        implements core.basesyntax.strategy.FruitTransactionAction {
    @Override
    public Integer transactionAction(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity();
    }
}
