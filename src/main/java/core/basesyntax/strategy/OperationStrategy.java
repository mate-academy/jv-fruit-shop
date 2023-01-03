package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperationServiceImpl;
import core.basesyntax.strategy.impl.PurchaseOperationServiceImpl;
import core.basesyntax.strategy.impl.ReturnOperationServiceImpl;
import core.basesyntax.strategy.impl.SupplyOperationServiceImpl;

public class OperationStrategy {
    public OperationService getOperationService(FruitTransaction transaction) {
        switch (transaction.getOperation().toString()) {
            case "BALANCE":
                return new BalanceOperationServiceImpl();
            case "SUPPLY":
                return new SupplyOperationServiceImpl();
            case "PURCHASE":
                return new PurchaseOperationServiceImpl();
            case "RETURN":
                return new ReturnOperationServiceImpl();
            default:
                throw new UnsupportedOperationException(
                        "Operation " + transaction.getOperation() + " is not supported");
        }
    }
}
