package core.basesyntax.strategy;

import core.basesyntax.dto.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler findHandler(FruitTransaction.Operation operation);
}
