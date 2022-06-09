package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitService {
    void add(FruitTransaction fruitTransaction);

    String getAll();
}
