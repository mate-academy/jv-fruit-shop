package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationPerformer get(FruitTransaction transaction);
}
