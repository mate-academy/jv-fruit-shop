package core.basesyntax.strategy.handler;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.dto.ProductTransaction;

public abstract class OperationHandler {
    protected final ProductStorage productStorage;

    public OperationHandler(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public abstract void handle(ProductTransaction productTransaction);
}
