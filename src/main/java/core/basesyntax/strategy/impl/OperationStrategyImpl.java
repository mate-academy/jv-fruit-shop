package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;

public class OperationStrategyImpl implements OperationStrategy {

    @Override
    public OperationHandler getHandlerByOperation(FruitTransaction.Operation operation) {
        switch (operation) {
            case BALANCE:
                return new BalanceOperationHandler();
            case PURCHASE:
                return new PurchaseOperationHandler();
            case RETURN:
                return new ReturnOperationHandler();
            case SUPPLY:
                return new SupplyOperationHandler();
            default:
                throw new RuntimeException("No such operation: " + operation);
        }
    }
}

