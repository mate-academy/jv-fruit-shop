package core.basesyntax.services.operations;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.StorageService;

public class PurchaseOperation implements OperationHandler {
    private StorageService storageService;

    public PurchaseOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int currentQuantity = storageService.getQuantity(fruit);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in storage");
        }
        storageService.remove(fruit, quantity);
    }
}
