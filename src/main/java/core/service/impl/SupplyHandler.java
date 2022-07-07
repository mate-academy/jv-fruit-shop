package core.service.impl;

import core.db.FruitTransaction;
import core.db.StorageService;
import core.service.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private static final int OPERATION_SIGN = 1;
    private final StorageService<FruitTransaction> storageService;

    public SupplyHandler(StorageService<FruitTransaction> storageService) {
        this.storageService = storageService;
    }

    @Override
    public void addTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        Integer newFruitQuantity = storageService.getFruitQuantity(fruit)
                + OPERATION_SIGN * transaction.getQuantity();
        storageService.setFruitQuantity(fruit, newFruitQuantity);
    }
}
