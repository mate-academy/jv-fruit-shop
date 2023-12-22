package core.basesyntax.operationhandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public interface OperationHandler {
    void handleOperation(FruitTransaction transaction, Storage storage);

}
