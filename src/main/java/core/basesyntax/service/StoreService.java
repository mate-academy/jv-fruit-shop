package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface StoreService {
    List<Fruit> setFruits(FruitService fruitService);
}
