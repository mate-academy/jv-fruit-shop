package strategy.operationstrategy;

import model.FruitTransaction;
import strategy.transactionhandlers.TransactionHandler;

public interface OperationStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
