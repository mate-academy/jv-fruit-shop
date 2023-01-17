package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitTransactionHandler;
import core.basesyntax.strategy.OperationCalculator;
import core.basesyntax.strategy.impl.BalanceOperationCalculatorImpl;
import core.basesyntax.strategy.impl.PurchaseOperationCalculatorImpl;
import core.basesyntax.strategy.impl.ReturnOperationCalculatorImpl;
import core.basesyntax.strategy.impl.SupplyOperationCalculatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitTransactionHandlerImpl implements FruitTransactionHandler {
    private Map<Operation, OperationCalculator> operationsMap;

    public FruitTransactionHandlerImpl() {
        operationsMap = new HashMap<>();
        operationsMap.put(Operation.BALANCE, new BalanceOperationCalculatorImpl());
        operationsMap.put(Operation.PURCHASE, new PurchaseOperationCalculatorImpl());
        operationsMap.put(Operation.RETURN, new ReturnOperationCalculatorImpl());
        operationsMap.put(Operation.SUPPLY, new SupplyOperationCalculatorImpl());
    }

    public void handle(Map<String, Integer> fruits,
                       List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(t -> {
            String fruitName = t.getFruit();
            int currentBalance = fruits.get(fruitName) == null ? 0 : fruits.get(fruitName);
            OperationCalculator operationCalculator =
                    operationsMap.get(Operation.getOperationByFirstLetter(t.getOperation()));
            Integer newBalance = operationCalculator.calculate(currentBalance, t.getQuantity());
            fruits.put(fruitName, newBalance);
        });
    }
}
