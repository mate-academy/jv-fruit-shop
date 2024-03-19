package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.strategy.Operation;

public class BalanceOperation implements Operation {
    private final StorageService storageService;

    public BalanceOperation() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public void execute(Transaction transaction) {
        String name = transaction.getName();
        int quantity = transaction.getQuantity();

        storageService.save(name, quantity);
    }
}
