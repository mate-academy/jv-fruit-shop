package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    private final StorageService storageService;

    public ReturnOperation() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public void handle(Transaction transaction) {
        String name = transaction.getFruitName();
        int returnedQuantity = transaction.getQuantity();
        int quantity = storageService.get(name);

        storageService.add(name, quantity + returnedQuantity);
    }
}
