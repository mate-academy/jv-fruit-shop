package core.basesyntax;

import core.basesyntax.model.Fruit;

public interface Supplier<T> {
    void supplyFruit(Fruit fruit);
}
