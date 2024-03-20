package core.basesyntax.strategyimpl;

import core.basesyntax.service.Strategy;
import core.basesyntax.serviceimpl.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class StrategyImpl implements Strategy {

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        if (operation.equals(FruitTransaction.Operation.BALANCE)) {
            return new BalanceHandler();
        }
        if (operation.equals(FruitTransaction.Operation.RETURN)) {
            return new ReturnHandler();
        }
        if (operation.equals(FruitTransaction.Operation.SUPPLY)) {
            return new SupplyHandler();
        }
        if (operation.equals(FruitTransaction.Operation.PURCHASE)) {
            return new PurchaseHandler();
        }
        return null;
    }
}
