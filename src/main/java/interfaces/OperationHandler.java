package interfaces;

import service.impl.FruitTransaction;

public interface OperationHandler {
    public void apply(FruitTransaction tx);
}
