package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FactoryStrategy;
import core.basesyntax.strategy.OperationService;
import java.util.List;

public class TransactionService {
    private final FactoryStrategy factoryStrategy;

    public TransactionService() {
        factoryStrategy = new FactoryStrategy();
    }

    public void processing(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationService operationService = factoryStrategy
                    .getOperationService(transaction.getOperation());
            operationService.executeOperation(transaction.getFruit(), transaction.getAmount());
        }
    }
}
