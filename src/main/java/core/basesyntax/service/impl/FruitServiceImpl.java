package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.OperationsStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    @Override
    public void getAllOperationsStrategy(List<FruitTransaction> fruitFromCsvRow,
                                      FruitStrategy fruitStrategy) {
        for (FruitTransaction fruitTransaction : fruitFromCsvRow) {
            OperationsStrategy operationsStrategy =
                    fruitStrategy.get(fruitTransaction.getOperation());
            operationsStrategy.handle(fruitTransaction);
        }
    }
}
