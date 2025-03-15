package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        if (Storage.fruits.containsKey(transaction.getFruit())) {
            if (Storage.fruits.get(transaction.getFruit()) < transaction.getQuantity()) {
                throw new RuntimeException("Not enough " + transaction.getFruit() + " in storage.");
            }
            Storage.fruits.put(transaction.getFruit(),
                    Storage.fruits.get(transaction.getFruit()) - transaction.getQuantity());
        } else {
            throw new RuntimeException("Fruit "
                    + transaction.getFruit()
                    + " is not found in storage.");
        }
    }
}
