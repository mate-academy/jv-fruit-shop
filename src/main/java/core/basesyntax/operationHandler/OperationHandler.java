package core.basesyntax.operationHandler;

import core.basesyntax.FruitStore;
import core.basesyntax.FruitTransaction;

public interface OperationHandler {
    void handleOperation(FruitStore fruitStore, FruitTransaction transaction);

}
