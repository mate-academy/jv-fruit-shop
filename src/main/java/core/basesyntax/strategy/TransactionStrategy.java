package core.basesyntax.strategy;

import core.basesyntax.service.OperationHandler;

public interface TransactionStrategy {
    OperationHandler get(String key);
}
