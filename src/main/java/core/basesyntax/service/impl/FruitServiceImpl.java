package core.basesyntax.service.impl;

import core.basesyntax.OperationsStrategy;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.FruitStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    @Override
    public void getAllOperationsStrategy(List<Fruit> fruitFromCsvRow,
                                         FruitStrategy fruitStrategy) {
        for (Fruit fruitTransaction : fruitFromCsvRow) {
            OperationsStrategy operationsStrategy =
                    fruitStrategy.get(fruitTransaction.getOperation());
            operationsStrategy.handle(fruitTransaction);
        }
    }
}
