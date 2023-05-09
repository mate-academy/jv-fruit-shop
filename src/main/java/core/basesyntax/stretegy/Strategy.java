package core.basesyntax.stretegy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.stretegy.handlers.OperationHandler;

public interface Strategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
