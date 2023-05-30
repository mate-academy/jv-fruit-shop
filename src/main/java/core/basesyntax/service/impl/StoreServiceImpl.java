package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StoreService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class StoreServiceImpl implements StoreService {
    private final OperationStrategy operationStrategy;

    public StoreServiceImpl() {
        operationStrategy = new OperationStrategyImpl();
    }

    @Override
    public void dataProcess(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.getHandler(transaction.getOperation()).handle(transaction);
        }
    }
}
