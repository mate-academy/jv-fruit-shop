package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.ProcessTransaction;
import core.basesyntax.dao.impl.ProcessTransactionImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final ProcessTransaction processTransaction;

    public PurchaseHandler() {
        processTransaction = new ProcessTransactionImpl();
    }

    @Override
    public void processOperation(FruitTransaction transaction) {
        processTransaction.takeFromBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
