package core.operationstrategy;

import core.service.OperationType;
import core.transactions.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(OperationType operation);
}
