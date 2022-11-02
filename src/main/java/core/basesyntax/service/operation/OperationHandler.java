package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int doOperation(int balance, int quantity);
}
