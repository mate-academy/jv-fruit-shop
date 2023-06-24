package core.strategy;

import core.model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
