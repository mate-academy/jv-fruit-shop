package core.basesyntax;

import core.basesyntax.model.Fruit;

public interface Consumer<T> {
    void sellFruit(Fruit fruit);
}
