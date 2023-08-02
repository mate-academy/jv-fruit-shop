package core.basesyntax.service.impl;

import core.basesyntax.handler.BalanceHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceImpl implements OperationHandler {
    private final BalanceHandler balanceHandler;

    public BalanceImpl(BalanceHandler balanceHandler) {
        this.balanceHandler = balanceHandler;
    }

    @Override
    public boolean applyOperation(FruitTransaction fruitTransaction) {
        FruitTransaction newFruit = new FruitTransaction.FruitBuilder()
                .setOperationType(fruitTransaction.getOperationType())
                .setFruitName(fruitTransaction.getFruitName())
                .setFruitQuantity(fruitTransaction.getFruitQuantity())
                .build();
        return balanceHandler.add(newFruit);
    }
}

