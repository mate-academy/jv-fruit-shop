package core.basesyntax.handlers;

import core.basesyntax.model.FruitTransaction;

public interface FruitPars {
    static FruitTransaction.Operation parse(String value) {
        for (FruitTransaction.Operation op : FruitTransaction.Operation.values()) {
            if (op.getCode().equals(value)) {
                return op;
            }
        }
        throw new RuntimeException("Unknown operation: " + value);
    }
}
