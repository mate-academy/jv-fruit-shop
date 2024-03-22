package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.service.OperationHandler;

public class BalanceOperation implements OperationHandler {
    private final StorageService storageService;

    public BalanceOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void perform(FruitsTransaction fruitsTransaction) {
        storageService.add(fruitsTransaction.getName(), fruitsTransaction.getQuantity());
    }
}
