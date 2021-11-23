package core.basesyntax.service.operationhandler;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction fruit);
}
