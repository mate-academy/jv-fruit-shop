package strategy;

import model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation codeOperation);
}
