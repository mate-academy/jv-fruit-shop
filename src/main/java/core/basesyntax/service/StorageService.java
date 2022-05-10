package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface StorageService {
    void add(Fruit fruit, int amount);

    void get(Fruit fruit, int amount);

    void updateStorage(Fruit fruit, int amount);
}
