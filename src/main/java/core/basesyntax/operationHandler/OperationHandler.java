package core.basesyntax.operationHandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import core.basesyntax.Storage;

public interface OperationHandler {
    void handleOperation(FruitTransaction transaction, Storage storage);


}
