package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.TransactionHandler;
import core.basesyntax.dao.impl.TransactionHandlerImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final TransactionHandler processTransaction;

    public PurchaseHandler() {
        processTransaction = new TransactionHandlerImpl();
    }

    @Override
    public void processOperation(FruitTransaction transaction) {
        processTransaction.takeFromBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
