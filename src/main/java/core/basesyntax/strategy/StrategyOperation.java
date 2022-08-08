package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.operation.OperationHandler;

public interface StrategyOperation {
    OperationHandler getOperationHandler(Transaction.Type typeOperation);
}
