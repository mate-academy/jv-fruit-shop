package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.TransactionHandler;

public interface OperationStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
