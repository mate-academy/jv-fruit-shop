package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public interface TransactionStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
