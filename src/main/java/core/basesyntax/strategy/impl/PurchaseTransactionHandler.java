package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.QuantityService;
import core.basesyntax.service.impl.QuantityServiceImpl;
import core.basesyntax.strategy.TransactionHandler;

public class PurchaseTransactionHandler implements TransactionHandler {
    private final QuantityService service;

    public PurchaseTransactionHandler() {
        service = new QuantityServiceImpl();
    }

    @Override
    public void executeTransaction(FruitTransaction transaction) {
        service.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}
