package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.GeneralOperation;
import core.basesyntax.strategy.TransactionHandler;

public class ReturnHandler implements GeneralOperation {
    private final TransactionHandler processTransaction;

    public ReturnHandler() {
        processTransaction = new TransactionHandlerImpl();
    }

    @Override
    public void generalOperation(FruitTransaction transaction) {
        processTransaction.addToBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
