package core.basesyntax.service.operations;

import core.basesyntax.service.FruitTransaction;

public class Return implements IOperation {
    @Override
    public FruitTransaction.Operation getOperation() {
        return FruitTransaction.Operation.RETURN;
    }
}
