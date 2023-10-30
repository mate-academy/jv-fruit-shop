package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void process(FruitTransaction transaction, FruitStorage storage);
}

