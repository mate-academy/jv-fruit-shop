package strategy;

import fruittransaction.FruitTransaction;
import transactionexecutor.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
