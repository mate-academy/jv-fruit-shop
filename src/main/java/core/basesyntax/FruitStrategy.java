package core.basesyntax;

import core.basesyntax.OperationsStrategy;
import core.basesyntax.model.Fruit;

public interface FruitStrategy {
    OperationsStrategy get(Fruit.Operation operation);
}
