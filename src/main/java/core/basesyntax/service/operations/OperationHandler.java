package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int getQuantity(int quantity);
    void process (FruitTransaction transaction);

}
