package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.transaction.HandlerOperation;

public interface StrategyFruitTransaction {
    HandlerOperation execute(Operation operation);
}
