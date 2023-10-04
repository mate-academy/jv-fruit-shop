package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitService {
    void recordFruits(List<FruitTransaction> fruitTransaction);

    List<Fruit> getAllFruits();
}
