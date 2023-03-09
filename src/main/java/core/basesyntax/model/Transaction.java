package core.basesyntax.model;

import core.basesyntax.model.FruitTransaction.Operation;

public interface Transaction {
    String getProductName();

    Operation getOperation();

    int getQuantity();
}
