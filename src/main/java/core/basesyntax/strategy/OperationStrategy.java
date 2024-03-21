package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;
import core.basesyntax.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler findHandler(Transaction.Operation operation);
}
