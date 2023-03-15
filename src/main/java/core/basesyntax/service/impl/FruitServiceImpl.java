package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationHandlerStrategy operationStrategy;

    public FruitServiceImpl(OperationHandlerStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void handleTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
