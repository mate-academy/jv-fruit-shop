package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        try {
            Storage.remove(transaction.getFruit(), transaction.getQuantity());
        } catch (RuntimeException e) {
            throw new RuntimeException("Balance is negative");
        }
    }
}
