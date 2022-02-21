package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.QuantityAddOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationProcessMap;

    public OperationStrategyImpl() {
        this.operationProcessMap = new HashMap<>();
        operationProcessMap.put(FruitTransaction.Operation.BALANCE,
                new QuantityAddOperationHandler());
        operationProcessMap.put(FruitTransaction.Operation.SUPPLY,
                new QuantityAddOperationHandler());
        operationProcessMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationProcessMap.put(FruitTransaction.Operation.RETURN,
                new QuantityAddOperationHandler());
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation fruitOperation) {
        return operationProcessMap.get(fruitOperation);
    }
}
