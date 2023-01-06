package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final OperationStrategy operationStrategy = new OperationStrategy();

    @Override
    public void update(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler storageService = operationStrategy.getHandler(transaction);
            storageService.handle(transaction);
        }
    }
}
