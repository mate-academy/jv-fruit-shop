package core.basesyntax.service.operations;

import core.basesyntax.service.FruitTransaction;

public class Supply implements IOperation {
    @Override
    public FruitTransaction.Operation getOperation() {
        return FruitTransaction.Operation.SUPPLY;
    }
}
