package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperationStrategy;
import core.basesyntax.strategy.impl.PurchaseOperationStrategy;
import core.basesyntax.strategy.impl.ReturnOperationStrategy;
import core.basesyntax.strategy.impl.SupplyOperationStrategy;

public class OperationStrategyImpl {
    public OperationStrategy getOperationStrategy(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case PURCHASE:
                return new PurchaseOperationStrategy();
            case RETURN:
                return new ReturnOperationStrategy();
            case SUPPLY:
                return new SupplyOperationStrategy();
            default:
            case BALANCE:
                return new BalanceOperationStrategy();
        }
    }
}
