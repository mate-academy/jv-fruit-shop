package core.basesyntax.service.operations;

import core.basesyntax.service.FruitTransaction;

public class Purchase implements IOperation{
    @Override
    public FruitTransaction.Operation getOperation() {
        return FruitTransaction.Operation.PURCHASE;
    }
}
