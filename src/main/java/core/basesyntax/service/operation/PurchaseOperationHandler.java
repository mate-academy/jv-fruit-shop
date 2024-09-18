package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageService storageService;

    public PurchaseOperationHandler(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(FruitTransaction transaction, StorageService storageService) {
        int currentQuantity = storageService.getFruitQuantity(transaction.getFruit());
        storageService.addFruit(transaction.getFruit(), -transaction.getQuantity());
    }
}
