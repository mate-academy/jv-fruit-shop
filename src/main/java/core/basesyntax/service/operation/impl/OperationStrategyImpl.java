package core.basesyntax.service.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        switch (operation) {
            case BALANCE: return new BalanceOperationHandler();
            case SUPPLY: return new SupplyOperationHandler();
            case RETURN: return new ReturnOperationHandler();
            case EXPIRED: return new ExpiredOperationHandler();
            case PURCHASE: return new PurchaseOperationHandler();
            default: throw new RuntimeException("Cannot find operation: " + operation.toString());
        }
    }
}
