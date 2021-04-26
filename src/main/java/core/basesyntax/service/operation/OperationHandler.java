package core.basesyntax.service.operation;

import core.basesyntax.model.Product;

public interface OperationHandler {
    int apply(int amount, Product key);
}
