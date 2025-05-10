package core.basesyntax.opationstrategy;

import core.basesyntax.operations.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
