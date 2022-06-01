package strategy;

import model.FruitTransaction;

public interface FruitTransactionStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
