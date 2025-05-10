package strategy;

import model.Transaction;
import service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Transaction.Operation operationType);

}
