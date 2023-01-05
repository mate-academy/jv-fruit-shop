package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private OperationStrategy strategy;

    public FruitTransactionServiceImpl() {
        strategy = new OperationStrategy();
    }

    @Override
    public void update(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler storageService = strategy.getOperationService(transaction);
            storageService.handle(transaction);
        }
    }
}
