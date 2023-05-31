package core.basesyntax;

import core.basesyntax.model.Fruit;

public interface OperationsStrategy {
    void handle(Fruit fruitTransaction);
}
