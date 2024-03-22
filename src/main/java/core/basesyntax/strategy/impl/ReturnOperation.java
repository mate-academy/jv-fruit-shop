package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.service.OperationHandler;

public class ReturnOperation implements OperationHandler {
    private final StorageService storageService;

    public ReturnOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(FruitsTransaction fruitsTransaction) {
        storageService.updateQuantity(fruitsTransaction.getName(),
                storageService.getQuantity(fruitsTransaction.getName())
                        + fruitsTransaction.getQuantity());
    }
}
