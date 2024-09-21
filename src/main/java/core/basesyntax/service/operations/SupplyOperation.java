package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.exceptions.InvalidFruitException;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (Storage.containsKey(transaction.getFruit())) {
            int newValue = Storage.getQuantity(transaction.getFruit())
                    + transaction.getQuantity();
            Storage.put(transaction.getFruit(), newValue);
        } else {
            throw new InvalidFruitException("Fruit: " + transaction.getFruit()
            + " wasn't found in the storage.");
        }
    }
}
