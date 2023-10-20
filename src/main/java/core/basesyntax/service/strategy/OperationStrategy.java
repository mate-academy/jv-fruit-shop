package core.basesyntax.service.strategy;

import core.basesyntax.service.counter.OperationHandler;
import core.basesyntax.service.transaction.FruitTransaction;

public interface OperationStrategy {

    OperationHandler getOperationType(FruitTransaction fruitTransaction);
}
