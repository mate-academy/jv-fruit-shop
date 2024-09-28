package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface StorageService {
    void decrement(Fruit fruit, int quantity);

    void increment(Fruit fruit, int quantity);

    int getQuantity(Fruit fruit);
}
