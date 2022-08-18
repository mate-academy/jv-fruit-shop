package core.strategy;

import core.model.FruitTransaction;
import core.operations.Operation;

public interface OperationStrategy {
    Operation get(FruitTransaction.Activity activity);
}
