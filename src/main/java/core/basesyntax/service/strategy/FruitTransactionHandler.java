package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionHandler {
    void execute(FruitTransaction fruitTransaction);
}
