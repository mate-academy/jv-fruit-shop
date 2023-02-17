package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.transaction.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler get(Operation operation);
}
