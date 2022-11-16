package core.basesyntax.service.operations;

import core.basesyntax.service.FruitTransaction;

public class Balance implements IOperation {
    @Override
    public FruitTransaction.Operation getOperation() {
        return FruitTransaction.Operation.BALANCE;
    }
}
