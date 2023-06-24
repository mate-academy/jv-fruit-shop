package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public interface StrategyOptions {
    OperationHandler get(FruitTransaction.Operation type);
}
