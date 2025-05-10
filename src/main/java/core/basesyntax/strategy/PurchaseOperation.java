package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;

public class PurchaseOperation implements OperationHandler {
    private StorageService storageService;

    public PurchaseOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storageService.removeFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
