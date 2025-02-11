package core.basesyntax.services.operations;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.StorageService;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    private StorageService storageService;

    public SupplyOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        storageService.add(transaction.getFruit(), transaction.getQuantity());
    }
}
