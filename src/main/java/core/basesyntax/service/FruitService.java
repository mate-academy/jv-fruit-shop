package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitStrategy;
import java.util.List;

public interface FruitService {
    void getAllTypeStrategy(List<FruitTransaction> fruitTransaction,
                                  FruitStrategy fruitStrategy);
}
