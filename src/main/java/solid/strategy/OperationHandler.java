package solid.strategy;

import solid.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}

