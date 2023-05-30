package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationService;
import core.basesyntax.storage.TemporaryStorage;

public class SupplyOperationService implements OperationService {
    @Override
    public void calculateByOperation(FruitTransaction fruitTransaction) {
        if (isOnBalanceSheet(fruitTransaction)) {
            int oldValue = TemporaryStorage.temporaryStorage.get(fruitTransaction.getFruit());
            int newValue = oldValue + fruitTransaction.getQuantity();
            TemporaryStorage.temporaryStorage.put(fruitTransaction.getFruit(), newValue);
        } else {
            TemporaryStorage.temporaryStorage.put(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
    }
}
