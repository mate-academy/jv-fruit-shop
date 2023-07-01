package core.basesyntax.model;

import core.basesyntax.service.strategy.BalanceOperationStrategy;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.PurchaseOperationStrategy;
import core.basesyntax.service.strategy.ReturnOperationStrategy;
import core.basesyntax.service.strategy.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    protected String fruit;
    protected int quantity;
    private Operation operation;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public static Map<String, OperationStrategy> createOperationStrategies() {
        Map<String, OperationStrategy> operationStrategies = new HashMap<>();
        operationStrategies.put("b", new BalanceOperationStrategy());
        operationStrategies.put("s", new SupplyOperationStrategy());
        operationStrategies.put("p", new PurchaseOperationStrategy());
        operationStrategies.put("r", new ReturnOperationStrategy());
        return operationStrategies;
    }
}

