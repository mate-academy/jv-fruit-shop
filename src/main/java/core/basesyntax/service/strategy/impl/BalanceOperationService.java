package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationService;
import core.basesyntax.storage.TemporaryStorage;

public class BalanceOperationService implements OperationService {
    @Override
    public void calculateByOperation(FruitTransaction fruitTransaction) {
        if (isOnBalanceSheet(fruitTransaction)) {
            throw new RuntimeException("Storage already have data for \""
                    + fruitTransaction.getFruit()
                            + "\" current balance. Please, check the input file");
        } else {
            TemporaryStorage.temporaryStorage.put(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
    }
}
