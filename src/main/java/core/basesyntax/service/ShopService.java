package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface ShopService {
    void transfer(Fruit fruitType, Integer amount);
}
