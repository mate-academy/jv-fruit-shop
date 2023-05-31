package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.FruitStrategy;
import java.util.List;

public interface FruitService {
    void getAllOperationsStrategy(List<Fruit> fruitTransaction,
                                  FruitStrategy fruitStrategy);
}
