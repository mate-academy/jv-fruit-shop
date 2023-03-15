package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.CalculateStrategy;
import core.basesyntax.strategy.OperationHandler;

public class CalculateStrategyImpl implements CalculateStrategy {
    @Override
    public OperationHandler getHandler(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case RETURN:
                return new ReturnHandler();
            case SUPPLY:
                return new SupplyHandler();
            case PURCHASE:
                return new PurchaseHandler();
            default:
                return new BalanceHandler();
        }
    }
}
