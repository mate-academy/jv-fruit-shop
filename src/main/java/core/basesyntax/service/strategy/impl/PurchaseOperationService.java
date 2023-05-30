package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationService;
import core.basesyntax.storage.TemporaryStorage;

public class PurchaseOperationService implements OperationService {
    @Override
    public void calculateByOperation(FruitTransaction fruitTransaction) {
        if (isOnBalanceSheet(fruitTransaction)) {
            int oldValue = TemporaryStorage.temporaryStorage.get(fruitTransaction.getFruit());
            int newValue = oldValue - fruitTransaction.getQuantity();
            TemporaryStorage.temporaryStorage.put(fruitTransaction.getFruit(), newValue);
        } else {
            throw new RuntimeException(fruitTransaction.getFruit() + " fruit"
                    + " isn't on the balance sheet. You can't "
                    + "purchase it");
        }
    }
}
