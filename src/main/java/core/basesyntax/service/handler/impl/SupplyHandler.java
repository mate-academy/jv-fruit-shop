package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.ProcessTransaction;
import core.basesyntax.dao.impl.ProcessTransactionImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final ProcessTransaction processTransaction;

    public SupplyHandler() {
        processTransaction = new ProcessTransactionImpl();
    }

    @Override
    public void processOperation(FruitTransaction transaction) {
        processTransaction.addToBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
