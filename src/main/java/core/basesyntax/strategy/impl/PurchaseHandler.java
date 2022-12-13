package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.HandlerAllOperation;
import core.basesyntax.strategy.TransactionHandler;

public class PurchaseHandler implements HandlerAllOperation {
    private final TransactionHandler transactionHandler;

    public PurchaseHandler() {
        transactionHandler = new TransactionHandlerImpl();
    }

    @Override
    public void handlerAllOperation(FruitTransaction transaction) {
        transactionHandler.takeFromBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
