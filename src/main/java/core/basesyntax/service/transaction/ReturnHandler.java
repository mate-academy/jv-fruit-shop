package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements TransactionHandler {
    @Override
    public FruitTransaction.Operation getOperation() {
        return FruitTransaction.Operation.RETURN;
    }
}
