package interfaces;

import service.impl.FruitTransaction;

public interface OperationStrategy {
    public OperationHandler get(FruitTransaction.Operation op);
}
