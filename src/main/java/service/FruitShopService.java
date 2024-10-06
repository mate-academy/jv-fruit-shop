package service;
//FruitShopService
import exception.OperationException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.OperationType;
import strategy.OperationHandler;

public class FruitShopService {
    private final Map<String, Integer> fruitInventory = new HashMap<>();
    private final Map<OperationType, OperationHandler> operationStrategy;

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
                throw new OperationException("Unknown operation type: " + operation);
            }
            handler.apply(fruitInventory, fruit, quantity);
        }
    }

    public Map<String, Integer> getInventory() {
        return Collections.unmodifiableMap(fruitInventory);
    }
}
