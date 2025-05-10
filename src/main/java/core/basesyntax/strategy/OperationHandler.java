package core.basesyntax.strategy;

import core.basesyntax.model.ShopTransaction;

public interface OperationHandler {
    void handle(ShopTransaction shopTransaction);
}
