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
        int totalAmount = storageService
                .get(new Fruit(fruitTransaction.getFruit()), fruitTransaction.getQuantity());
        int remnant = totalAmount - fruitTransaction.getQuantity();
        if (totalAmount < fruitTransaction.getQuantity()) {
            throw new RuntimeException("There is no such amount in the store. The amount is "
                    + totalAmount);
        }
        storageService.update(new Fruit(fruitTransaction.getFruit()), remnant);
    }
}
