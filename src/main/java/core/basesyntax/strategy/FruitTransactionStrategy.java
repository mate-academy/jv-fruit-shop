package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperationService;
import core.basesyntax.service.impl.FruitPurchaseService;
import core.basesyntax.service.impl.FruitSupplyService;

public class FruitTransactionStrategy {
    public FruitOperationService getFruitOperationService(FruitTransaction.Operation operation) {
        if (operation == FruitTransaction.Operation.PURCHASE) {
            return new FruitPurchaseService();
        }
        return new FruitSupplyService();
    }
}
