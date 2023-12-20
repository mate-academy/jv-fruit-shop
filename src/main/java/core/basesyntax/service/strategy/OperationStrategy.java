package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation fruitTransaction);

}
