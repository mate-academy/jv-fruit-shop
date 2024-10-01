package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface StorageService {
    void addFruit(Fruit fruit, int quantity);

    void removeFruit(Fruit fruit, int quantity);

    int getQuantity(Fruit fruit);
}
