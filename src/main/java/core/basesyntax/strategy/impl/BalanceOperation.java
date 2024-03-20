package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    private final StorageService storageService;

    public BalanceOperation() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public void handle(Transaction transaction) {
        String name = transaction.getFruitName();
        int quantity = transaction.getQuantity();

        storageService.add(name, quantity);
    }
}
