package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.impl.FruitTransaction;

public class PurchaseOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.getFruitStorge().replace(transaction.getFruit(),
                Storage.getFruitStorge().get(transaction.getFruit())
                - transaction.getQuantity());
    }
}
