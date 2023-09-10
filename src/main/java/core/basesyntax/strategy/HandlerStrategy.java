package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface HandlerStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
