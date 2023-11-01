package core.basesyntax.transactions;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {

    void processTransaction(FruitTransaction transaction);
}
