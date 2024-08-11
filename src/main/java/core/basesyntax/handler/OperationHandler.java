package core.basesyntax.handler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.model.Product;

public interface OperationHandler {
    void transaction (FruitTransaction fruitTransaction, Product product);
}
