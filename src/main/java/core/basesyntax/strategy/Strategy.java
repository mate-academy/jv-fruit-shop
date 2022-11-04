package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.models.FruitTransaction;

public interface Strategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
