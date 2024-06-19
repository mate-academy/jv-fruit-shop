package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public ShopServiceImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void processTransactions(
            List<FruitTransaction> transactions, Map<String, Integer> inventory) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationHandlers.get(transaction.getOperation());
            if (handler != null) {
                handler.handle(transaction, inventory);
            } else {
                throw new RuntimeException("Unknown operation: " + transaction.getOperation());
            }
        }
    }
}
