package core.basesyntax.operationHandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import core.basesyntax.Storage;

public interface OperationHandler {
    void handleOperation(FruitTransaction transaction, Storage storage);

}

//OperationHandler and an implementation for each operation type, each OperationHandler should make changes to the storage