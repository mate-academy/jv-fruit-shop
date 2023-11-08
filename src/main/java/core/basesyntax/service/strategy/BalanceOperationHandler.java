package core.basesyntax.service.strategy;

import core.basesyntax.exceptions.InvalidDataException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new InvalidDataException("Balance can't be negative");
        }
        FruitStorage.storageMap.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
