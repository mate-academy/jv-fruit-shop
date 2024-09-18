package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageService storageService;

    public SupplyOperationHandler(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(FruitTransaction transaction, StorageService storageService) {
        storageService.addFruit(transaction.getFruit(),transaction.getQuantity());
    }
}
