package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;

public class SupplyOperation implements OperationHandler {
    private final StorageService storageService;

    public SupplyOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storageService.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
