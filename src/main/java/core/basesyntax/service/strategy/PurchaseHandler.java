package core.basesyntax.service.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;

public class PurchaseHandler implements OperationHandler {
    private StorageService storageService;

    public PurchaseHandler() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int remnant = storageService
                .get(new Fruit(fruitTransaction.getFruit()), fruitTransaction.getQuantity());
        storageService.update(new Fruit(fruitTransaction.getFruit()), remnant);
    }
}
