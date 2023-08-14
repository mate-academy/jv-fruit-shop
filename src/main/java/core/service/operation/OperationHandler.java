package core.service.operation;

import core.model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
