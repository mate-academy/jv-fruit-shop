package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.service.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private final StorageService storageService;

    public PurchaseOperation(StorageService storage) {
        this.storageService = storage;
    }

    @Override
    public void perform(FruitsTransaction fruitsTransaction) {
        storageService.updateQuantity(fruitsTransaction.getName(), storageService
                .getQuantity(fruitsTransaction.getName()) - fruitsTransaction.getQuantity());
    }
}

