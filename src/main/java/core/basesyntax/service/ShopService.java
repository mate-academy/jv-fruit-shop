package core.basesyntax.service;

import core.basesyntax.model.FruitInStorage;

public interface ShopService {
    FruitInStorage addFruits(String fruit, int amount);

    FruitInStorage removeFruits(String fruit, int amount);
}
