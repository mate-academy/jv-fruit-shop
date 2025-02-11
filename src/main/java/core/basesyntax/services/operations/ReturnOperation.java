package core.basesyntax.services.operations;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.StorageService;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    private StorageService storageService;

    public ReturnOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        storageService.add(transaction.getFruit(), transaction.getQuantity());
    }
}
