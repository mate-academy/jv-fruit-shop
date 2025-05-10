package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    private final StorageService storageService;

    public BalanceOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storageService.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
