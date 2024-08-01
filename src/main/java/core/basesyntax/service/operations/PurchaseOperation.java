package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.getAllFruits().put(transaction.getFruit(), Storage.getAllFruits()
                .getOrDefault(transaction.getFruit(), 0) - transaction.getQuantity());
    }
}
