package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.QuantityService;
import core.basesyntax.service.impl.QuantityServiceImpl;
import core.basesyntax.strategy.TransactionHandler;

public class BalanceTransactionHandler implements TransactionHandler {
    private final QuantityService service;

    public BalanceTransactionHandler() {
        service = new QuantityServiceImpl();
    }

    @Override
    public void executeTransaction(FruitTransaction transaction) {
        service.add(transaction.getFruit(), transaction.getQuantity());
    }
}
