package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;
import core.basesyntax.service.impl.FruitBalanceService;
import core.basesyntax.service.impl.FruitPurchaseService;
import core.basesyntax.service.impl.FruitReturnService;
import core.basesyntax.service.impl.FruitSupplyService;

public class FruitTransactionStrategy {
    public FruitTransactionHandler getFruitTransactionService(
            FruitTransaction.Operation operation) {
        switch (operation) {
            case PURCHASE:
                return new FruitPurchaseService();
            case SUPPLY:
                return new FruitSupplyService();
            case RETURN:
                return new FruitReturnService();
            case BALANCE:
                return new FruitBalanceService();
            default:
                throw new RuntimeException("Illegal operation");
        }
    }
}
