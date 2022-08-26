package core.basesyntax.strategy;

import core.basesyntax.hadler.OperationHandler;
import core.basesyntax.model.FruitTransaction.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
