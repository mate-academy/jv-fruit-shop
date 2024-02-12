package strategy;

import model.FruitTransaction;
import strategy.operation.OperationHandler;

public interface TransactionStrategy {
    OperationHandler get(FruitTransaction.Operation transaction);
}
