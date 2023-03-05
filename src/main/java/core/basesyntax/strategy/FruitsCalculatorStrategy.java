package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.OperationStrategyBalanceImpl;
import core.basesyntax.strategy.impl.OperationStrategyPurchaseImpl;
import core.basesyntax.strategy.impl.OperationStrategyReturnImpl;
import core.basesyntax.strategy.impl.OperationStrategySupplyImpl;
import java.util.HashMap;
import java.util.Map;

public class FruitsCalculatorStrategy {
    private static final Map<FruitTransaction.Operation,
            OperationStrategy> strategyFruitsTransactionOperationsMap;

    static {
        strategyFruitsTransactionOperationsMap = new HashMap<>();
        strategyFruitsTransactionOperationsMap
                .put(FruitTransaction.Operation.BALANCE, new OperationStrategyBalanceImpl());
        strategyFruitsTransactionOperationsMap
                .put(FruitTransaction.Operation.PURCHASE, new OperationStrategyPurchaseImpl());
        strategyFruitsTransactionOperationsMap
                .put(FruitTransaction.Operation.RETURN, new OperationStrategyReturnImpl());
        strategyFruitsTransactionOperationsMap
                .put(FruitTransaction.Operation.SUPPLY, new OperationStrategySupplyImpl());
    }

    public int calculateQuantity(int quantityBefore, int current,
                                 FruitTransaction.Operation operation) {
        operationVerification(operation);
        OperationStrategy operationStrategy = strategyFruitsTransactionOperationsMap.get(operation);
        return operationStrategy.calculateQuantity(quantityBefore, current);
    }

    public int putPreviousPeriodQuantity(int current, FruitTransaction.Operation operation) {
        operationVerification(operation);
        OperationStrategy operationStrategy = strategyFruitsTransactionOperationsMap.get(operation);
        return operationStrategy.putPreviousPeriodQuantity(current);
    }

    private void operationVerification(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Operation shouldn't be null");
        }
        if (!strategyFruitsTransactionOperationsMap.containsKey(operation)) {
            throw new RuntimeException("Have to create strategy of operator "
                    + operation + ". It doesn't exist");
        }
    }
}
