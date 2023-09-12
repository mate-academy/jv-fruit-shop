package strategy;

import model.FruitTransaction;

public interface OperationStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
