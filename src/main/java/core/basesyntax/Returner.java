package core.basesyntax;

import core.basesyntax.model.Fruit;

public interface Returner<T> {
    void returnFruit(Fruit fruit);
}
