package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.exceptions.InvalidFruitException;
import core.basesyntax.service.exceptions.InvalidQuantityException;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new InvalidQuantityException("Incorrect quantity for supply operation. "
                    + "Given quantity is: " + transaction.getQuantity()
                    + " ,but it can't be negative value");
        }
        int newValue = Storage.getQuantity(transaction.getFruit())
                + transaction.getQuantity();
        Storage.put(transaction.getFruit(), newValue);
        if (!Storage.containsKey(transaction.getFruit())) {
            throw new InvalidFruitException("Fruit: " + transaction.getFruit()
            + " wasn't found in the storage.");
        }
    }
}
