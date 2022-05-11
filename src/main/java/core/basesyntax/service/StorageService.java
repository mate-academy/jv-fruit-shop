package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface StorageService {
    void add(Fruit fruit, int amount);

    int get(Fruit fruit, int amount);

    void update(Fruit fruit, int amount);
}
