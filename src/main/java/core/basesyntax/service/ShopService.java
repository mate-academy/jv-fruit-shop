package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface ShopService {
    void add(Fruit fruit, int amount);

    int get(Fruit fruit, int amount);
}
