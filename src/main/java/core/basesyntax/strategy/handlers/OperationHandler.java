package core.basesyntax.strategy.handlers;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public interface OperationHandler {
    void handle(FruitTransaction fruitTransaction, FruitStorage storage);
}
