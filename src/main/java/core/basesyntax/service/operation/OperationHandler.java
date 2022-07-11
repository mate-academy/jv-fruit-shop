package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void calculate(Fruit fruit, FruitTransaction transaction);
}
