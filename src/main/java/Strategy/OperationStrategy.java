package Strategy;

import Operations.OperationHandler;
import core.basesyntax.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
