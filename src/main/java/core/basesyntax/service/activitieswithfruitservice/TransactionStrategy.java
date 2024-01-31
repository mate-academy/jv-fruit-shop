package core.basesyntax.service.activitieswithfruitservice;

import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategy {
    TransactionHandler getTransactionHandler(FruitTransaction fruitTransaction);
}
