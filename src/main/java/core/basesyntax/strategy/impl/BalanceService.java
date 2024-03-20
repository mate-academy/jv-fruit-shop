package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.strategy.service.OperationHandler;

public class BalanceService implements OperationHandler {
    private final StorageService storageService;

    public BalanceService() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public void perform(FruitsTransaction fruitsTransaction) {
        storageService.add(fruitsTransaction.getName(), fruitsTransaction.getQuantity());
    }
}
