package core.basesyntax.service.operations;

import core.basesyntax.service.FruitTransaction;

public interface IOperation {
    FruitTransaction.Operation getOperation();
}
