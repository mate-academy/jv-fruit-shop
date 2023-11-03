package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransactionOperation;
import core.basesyntax.service.transaction.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransactionOperation operation);
}
