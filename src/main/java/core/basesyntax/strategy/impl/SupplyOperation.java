package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    private final StorageService storageService;

    public SupplyOperation() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public void handle(Transaction transaction) {
        String name = transaction.getFruitName();
        int supplyQuantity = transaction.getQuantity();
        int quantity = storageService.get(name);

        storageService.add(name, quantity + supplyQuantity);
    }
}
