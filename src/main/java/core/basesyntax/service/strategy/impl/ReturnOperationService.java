package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationService;
import core.basesyntax.storage.TemporaryStorage;

public class ReturnOperationService implements OperationService {
    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        if (isOnBalanceSheet(fruitTransaction)) {
            int oldValue = TemporaryStorage.temporaryStorage.get(fruitTransaction.getFruit());
            int newValue = oldValue + fruitTransaction.getQuantity();
            TemporaryStorage.temporaryStorage.put(fruitTransaction.getFruit(), newValue);
        } else {
            throw new RuntimeException(fruitTransaction.getFruit()
                    + "aren't on balance sheet. You can't return it");
        }
    }
}
