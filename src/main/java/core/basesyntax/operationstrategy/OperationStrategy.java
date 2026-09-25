package core.basesyntax.operationstrategy;

import core.basesyntax.fruittransaction.Operation;
import core.basesyntax.handlers.OperationHandler;

public interface OperationStrategy {
    public OperationHandler getTransactionHandler(Operation operation);

}
