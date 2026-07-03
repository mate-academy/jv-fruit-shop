package core.strategy;

import core.model.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction transaction);
}
