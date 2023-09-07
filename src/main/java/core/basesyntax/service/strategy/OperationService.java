package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.TemporaryStorage;

public interface OperationService {
    void performOperation(FruitTransaction fruitTransaction);

    default boolean isOnBalanceSheet(FruitTransaction fruitTransaction) {
        return TemporaryStorage.temporaryStorage.containsKey(fruitTransaction.getFruit());
    }
}
