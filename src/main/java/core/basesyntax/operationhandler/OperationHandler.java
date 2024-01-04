package core.basesyntax.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void handleOperation(FruitTransaction transaction, Storage storage);

}
