package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface QuantityService {
    void add(Fruit fruit, Integer quantity);

    void subtract(Fruit fruit, Integer quantity);
}
