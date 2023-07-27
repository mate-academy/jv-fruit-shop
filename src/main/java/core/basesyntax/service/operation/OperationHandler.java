package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int calculationData(int balance, FruitTransaction transaction);
}
