package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        int curentQuantity = Storage.getStorage().get(transaction.getFruit().getType());
        Storage.getStorage().put(transaction.getFruit()
                .getType(), curentQuantity + transaction.getQuantity());
    }
}
