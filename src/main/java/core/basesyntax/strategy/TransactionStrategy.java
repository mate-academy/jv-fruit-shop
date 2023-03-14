package core.basesyntax.strategy;

import core.basesyntax.service.operation.OperationHandler;

public interface TransactionStrategy {
    OperationHandler get(String operation);
}
