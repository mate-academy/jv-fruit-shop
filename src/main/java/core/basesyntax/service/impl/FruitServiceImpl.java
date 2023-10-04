package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    @Override
    public void writeActionToStorage(List<FruitTransaction> fruitTransactions,
                                     OperationStrategy strategy) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            strategy.getHandler(fruitTransaction.getOperation()).handle(fruitTransaction);
        }
    }
}
