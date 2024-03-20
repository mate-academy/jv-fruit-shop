package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.serviceimpl.StorageServiceImpl;
import core.basesyntax.strategy.service.OperationHandler;

public class PurchaseService implements OperationHandler {
    private final StorageService storageService;

    public PurchaseService() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public void perform(FruitsTransaction fruitsTransaction) {
        storageService.updateQuantity(fruitsTransaction.getName(), storageService
                .getQuantity(fruitsTransaction.getName()) - fruitsTransaction.getQuantity());
    }
}

