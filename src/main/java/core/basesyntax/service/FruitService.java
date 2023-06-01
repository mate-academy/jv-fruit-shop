package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public interface FruitService {
    FruitTransaction add(FruitTransaction fruitTransaction);

    FruitTransaction remove(FruitTransaction fruitTransaction);

    Map<String, Integer> getAll();
}
