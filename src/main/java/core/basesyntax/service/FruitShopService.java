package core.basesyntax.service;

import core.basesyntax.exception.UnknownOperationException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.strategy.OperationHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopService {
    private Map<String, Integer> fruitInventory = new HashMap<>();
    private Map<OperationType, OperationHandler> operationStrategy = new HashMap<>();

    public FruitShopService(Map<OperationType, OperationHandler> operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationType operation = transaction.getOperation();
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();
            OperationHandler handler = operationStrategy.get(operation);
            if (handler == null) {
                throw new UnknownOperationException("Unknown operation type: " + operation);
            }
            handler.apply(fruitInventory, fruit, quantity);
        }
    }

    public Map<String, Integer> getInventory() {
        return Collections.unmodifiableMap(fruitInventory);
    }
}
