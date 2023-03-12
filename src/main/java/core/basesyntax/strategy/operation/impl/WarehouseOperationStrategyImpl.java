package core.basesyntax.strategy.operation.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class WarehouseOperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> auditOperationServiceMap;

    public WarehouseOperationStrategyImpl() {
        auditOperationServiceMap = new HashMap<>();
        auditOperationServiceMap.put(Operation.BALANCE.getOperation(),
                new BalanceOperationImpl());
        auditOperationServiceMap.put(Operation.SUPPLY.getOperation(),
                new SupplyOperationImpl());
        auditOperationServiceMap.put(Operation.PURCHASE.getOperation(),
                new PurchaseOperationImpl());
        auditOperationServiceMap.put(Operation.RETURN.getOperation(),
                new ReturnOperationImpl());
    }

    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        auditOperationServiceMap.get(fruitTransaction.getOperation())
                        .applyOperation(fruitTransaction.getFruit(),
                                fruitTransaction.getQuantity());
    }
}
