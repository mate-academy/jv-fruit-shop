package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    @Override
    public void processTransactions(List<FruitTransaction> fruitFromCsvRow,
                                         FruitStrategy fruitStrategy) {
        for (FruitTransaction fruitTransaction : fruitFromCsvRow) {
            OperationHandler operationHandler =
                    fruitStrategy.get(fruitTransaction.getOperation());
            operationHandler.handle(fruitTransaction);
        }
    }
}
