package core.basesyntax.stratagy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
