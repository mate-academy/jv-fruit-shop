package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.CalculationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class CalculationStrategyImpl implements CalculationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> transactionsMap;

    public CalculationStrategyImpl() {
        transactionsMap = new HashMap<>();
        transactionsMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        transactionsMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        transactionsMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        transactionsMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
    }

    @Override
    public void calculate(FruitTransaction transaction) {
        transactionsMap.get(transaction.getOperation()).operate(transaction);
    }
}
