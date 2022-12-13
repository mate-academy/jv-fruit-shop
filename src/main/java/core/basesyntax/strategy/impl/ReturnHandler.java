package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.HandlerAllOperation;
import core.basesyntax.strategy.TransactionHandler;

public class ReturnHandler implements HandlerAllOperation {
    private final TransactionHandler processTransaction;

    public ReturnHandler() {
        processTransaction = new TransactionHandlerImpl();
    }

    @Override
    public void handlerAllOperation(FruitTransaction transaction) {
        processTransaction.addToBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
