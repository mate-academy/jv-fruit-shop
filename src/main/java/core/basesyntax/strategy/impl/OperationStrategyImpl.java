package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationProcessor> STRATEGY = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceProcessor(),
            FruitTransaction.Operation.SUPPLY, new SupplyProcessor(),
            FruitTransaction.Operation.PURCHASE, new PurchaseProcessor(),
            FruitTransaction.Operation.RETURN, new ReturnProcessor()
    );


    @Override
    public OperationProcessor get(FruitTransaction.Operation operation) {
        return STRATEGY.get(operation);
    }
}
