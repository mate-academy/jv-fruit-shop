package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    private final StorageService storageService;

    public ReturnOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storageService.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
