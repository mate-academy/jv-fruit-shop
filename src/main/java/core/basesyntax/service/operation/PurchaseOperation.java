package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.domain.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void calculateQuantity(FruitTransaction.FruitName fruitName, int quantity) {
        validateFruitName(fruitName);
        validateQuantity(quantity);
        if (Storage.getFruitTransactions().get(fruitName) == null) {
            Storage.getFruitTransactions().put(fruitName, quantity);
        } else {
            Integer oldValue = Storage.getFruitTransactions().get(fruitName);
            Integer newValue = oldValue - quantity;
            Storage.getFruitTransactions().replace(fruitName, oldValue, newValue);
        }
    }
}
