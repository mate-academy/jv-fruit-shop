package core.basesyntax.services.operations;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.StorageService;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements core.basesyntax.services.OperationHandler,
        OperationHandler {
    private StorageService storageService;

    public PurchaseOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    public PurchaseOperation() {
    }

    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int currentQuantity = storageService.getQuantity(fruit);
        if (currentQuantity >= quantity) {
            storageService.remove(fruit, quantity);
        } else {
            throw new RuntimeException("Not enough " + fruit + " in storage");
        }
    }
}
