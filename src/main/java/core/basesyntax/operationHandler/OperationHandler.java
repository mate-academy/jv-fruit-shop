package core.basesyntax.operationHandler;

import core.basesyntax.FruitStore;
import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;

public interface OperationHandler {
    void handleOperation(FruitStore fruitStore, FruitTransaction transaction, Operation operation);

}
