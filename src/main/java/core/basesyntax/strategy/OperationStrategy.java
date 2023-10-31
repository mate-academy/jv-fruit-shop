package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transactions.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
