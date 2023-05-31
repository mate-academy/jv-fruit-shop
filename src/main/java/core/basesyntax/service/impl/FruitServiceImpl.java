package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactionList,
                                    OperationStrategy strategy) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler = strategy.get(fruitTransaction
                    .getOperation());
            operationHandler.handle(fruitTransaction);
        }
    }
}
