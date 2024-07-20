package core.basesyntax.utility;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandlerSwitch {
    FruitTransaction.Operation getOperation(String operation);
}
