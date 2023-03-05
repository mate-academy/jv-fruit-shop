package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.OperationStrategyBalanceImpl;
import core.basesyntax.strategy.impl.OperationStrategyPurchaseImpl;
import core.basesyntax.strategy.impl.OperationStrategyReturnImpl;
import core.basesyntax.strategy.impl.OperationStrategySupplyImpl;
import java.util.HashMap;
import java.util.Map;

public class FruitsCalculatorStrategy {
    public int calculateQuantity(int quantityBefore, int current,
                                 FruitTransaction.Operation operation) {
        OperationStrategy operationStrategy = mapFruitsTransactionOperations().get(operation);
        return operationStrategy.calculateQuantity(quantityBefore, current);
    }

    public int putPreviousPeriodQuantity(int current, FruitTransaction.Operation operation) {
        OperationStrategy operationStrategy = mapFruitsTransactionOperations().get(operation);
        return operationStrategy.putPreviousPeriodQuantity(current);
    }

    private Map<FruitTransaction.Operation,
            OperationStrategy> mapFruitsTransactionOperations() {
        Map<FruitTransaction.Operation, OperationStrategy> map = new HashMap<>();
        map.put(FruitTransaction.Operation.PURCHASE, new OperationStrategyPurchaseImpl());
        map.put(FruitTransaction.Operation.RETURN, new OperationStrategyReturnImpl());
        map.put(FruitTransaction.Operation.SUPPLY, new OperationStrategySupplyImpl());
        map.put(FruitTransaction.Operation.BALANCE, new OperationStrategyBalanceImpl());
        return map;
    }
}
