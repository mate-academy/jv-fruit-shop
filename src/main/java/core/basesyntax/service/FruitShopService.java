package core.basesyntax.service;

import core.basesyntax.exception.UnknownOperationException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopService {
    private Map<String, Integer> fruitInventory = new HashMap<>();
    private Map<OperationType, OperationHandler> operationStrategy = new HashMap<>();

    public FruitShopService(Map<OperationType, OperationHandler> operationStrategy) {
        this.operationStrategy.put(OperationType.BALANCE, new BalanceOperationHandler());
        this.operationStrategy.put(OperationType.SUPPLY, new SupplyOperationHandler());
        this.operationStrategy.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        this.operationStrategy.put(OperationType.RETURN, new ReturnOperationHandler());
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
        return fruitInventory;
    }
}
