package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;
import java.util.HashMap;

public class OperationStrategyImpl implements OperationStrategy {
    private HashMap<String, OperationHandler> strategyStorage = new HashMap<>();

    public OperationStrategyImpl() {
        strategyStorage.put(FruitTransaction.Operation.BALANCE.getCode(),
                new BalanceOperationStrategy());
        strategyStorage.put(FruitTransaction.Operation.SUPPLY.getCode(),
                new SupplyOperationStrategy());
        strategyStorage.put(FruitTransaction.Operation.PURCHASE.getCode(),
                new PurchaseOperationStrategy());
        strategyStorage.put(FruitTransaction.Operation.RETURN.getCode(),
                new ReturnOperationStrategy());
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return strategyStorage.get(operation.getCode());
    }
}
