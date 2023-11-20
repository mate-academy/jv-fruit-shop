package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.impl.strategy.BalanceOperationServiceImpl;
import core.basesyntax.service.impl.strategy.PurchaseOperationServiceImpl;
import core.basesyntax.service.impl.strategy.ReturnOperationServiceImpl;
import core.basesyntax.service.impl.strategy.SupplyOperationServiceImpl;

public class FruitOperationStrategy {
    public OperationService getOperationService(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case BALANCE -> {
                return new BalanceOperationServiceImpl();
            }
            case PURCHASE -> {
                return new PurchaseOperationServiceImpl();
            }
            case RETURN -> {
                return new ReturnOperationServiceImpl();
            }
            case SUPPLY -> {
                return new SupplyOperationServiceImpl();
            }
            default -> throw new InvalidOperationException("Invalid operation type: "
                    + transaction.getOperation());
        }
    }
}
