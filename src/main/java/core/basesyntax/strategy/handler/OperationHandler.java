package core.basesyntax.strategy.handler;

import core.basesyntax.dto.ProductTransaction;

public abstract class OperationHandler {

    public abstract void handle(ProductTransaction productTransaction);
}
