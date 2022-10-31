package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.TransactionHandler;
import core.basesyntax.dao.impl.TransactionHandlerImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final TransactionHandler processTransaction;

    public ReturnHandler() {
        processTransaction = new TransactionHandlerImpl();
    }

    @Override
    public void processOperation(FruitTransaction transaction) {
        processTransaction.addToBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
