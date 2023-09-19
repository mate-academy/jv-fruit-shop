package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.handlers.BalanceHandler;
import core.basesyntax.service.strategy.handlers.PurchaseHandler;
import core.basesyntax.service.strategy.handlers.ReturnHandler;
import core.basesyntax.service.strategy.handlers.SupplyHandler;

public class HandleTransactionStrategyImpl implements HandleTransactionStrategy {
    @Override
    public TransactionHandler get(FruitTransaction.Operation type) {
        switch (type) {
            case BALANCE:
                return new BalanceHandler();
            case SUPPLY:
                return new SupplyHandler();
            case PURCHASE:
                return new PurchaseHandler();
            case RETURN:
                return new ReturnHandler();
            default:
                throw new RuntimeException("Specified type is incorrect");
        }
    }
}
