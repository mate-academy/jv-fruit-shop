package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public class FruitTransactionSupplier {
    public FruitTransaction.Operation get(String operationCode) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equalsIgnoreCase(operationCode)) {
                return operation;
            }
        }
        throw new RuntimeException("Operation code is not found");
    }
}
