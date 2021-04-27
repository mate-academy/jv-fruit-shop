package core.basesyntax.services;

import core.basesyntax.storage.FruitDataBase;

public interface FruitsService {
    void change(String fruit, Integer amount, FruitDataBase fruitDataBase);
}
