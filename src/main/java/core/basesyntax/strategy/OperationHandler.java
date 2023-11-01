package core.basesyntax.strategy;

import core.basesyntax.model.GoodsOperation;

public interface OperationHandler {
    void handleOperation(GoodsOperation operation);
}
