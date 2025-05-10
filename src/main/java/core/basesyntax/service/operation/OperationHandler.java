package core.basesyntax.service.operation;

import core.basesyntax.service.FruitStorage;
import core.basesyntax.service.FruitTransaction;

public interface OperationHandler {
    FruitStorage operation(FruitTransaction fruitTransaction, FruitStorage fruitStorage);
}
