package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.impl.FruitTransaction;

public class PurchaseOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.getFruitShop().replace(transaction.getFruit(),
                Storage.getFruitShop().get(transaction.getFruit())
                - transaction.getQuantity());
    }
}
