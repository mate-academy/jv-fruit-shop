package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;

public class BalanceOperation implements OperationHandler {
    private StorageService storageService;

    public BalanceOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        storageService.addFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
