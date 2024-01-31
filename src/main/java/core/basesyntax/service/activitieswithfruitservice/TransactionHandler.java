package core.basesyntax.service.activitieswithfruitservice;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void performTransaction(FruitTransaction fruitTransaction);
}
