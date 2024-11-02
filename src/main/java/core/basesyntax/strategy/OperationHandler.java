package core.basesyntax.strategy;

import core.basesyntax.model.ShopOperation;

public interface OperationHandler {
    void handle(ShopOperation shopOperation);
}
