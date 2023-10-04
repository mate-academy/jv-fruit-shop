package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandlerStrategy;
import java.util.List;

public interface FruitService {
    void processAllTransations(List<FruitTransaction> transactions,
                               FruitHandlerStrategy fruitHandlerStrategy);
}
