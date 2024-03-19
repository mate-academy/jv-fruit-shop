package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.strategy.Operation;

public class SupplyOperation implements Operation {
    private final StorageService storageService;

    public SupplyOperation() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public void execute(Transaction transaction) {
        String name = transaction.getName();
        int supplyQuantity = transaction.getQuantity();
        int quantity = storageService.get(name);

        storageService.update(name, quantity + supplyQuantity);
    }
}
