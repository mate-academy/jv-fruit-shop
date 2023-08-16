package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationActivity;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationActivity> operationActivities =
            new HashMap<>();

    public OperationStrategyImpl() {
        operationActivities
                .put(FruitTransaction.Operation.BALANCE, new BalanceOperationActivity());
        operationActivities
                .put(FruitTransaction.Operation.SUPPLY, new SuppliyOperationActivity());
        operationActivities
                .put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationActivity());
        operationActivities
                .put(FruitTransaction.Operation.RETURN, new ReturnOperationActivity());
    }

    @Override
    public OperationActivity get(FruitTransaction.Operation operation) {
        return operationActivities.get(operation);
    }
}
