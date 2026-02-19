package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private Map<FruitTransaction.Operation, OperationStrategy> operationHandlers;

    public ShopServiceImpl(Map<FruitTransaction.Operation, OperationStrategy> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationStrategy handler = operationHandlers.get(transaction.getOperation());
            if (handler == null) {
                throw new RuntimeException("Unknown operation: " + transaction.getOperation());
            }
            handler.apply(transaction);
        }

    }
}
