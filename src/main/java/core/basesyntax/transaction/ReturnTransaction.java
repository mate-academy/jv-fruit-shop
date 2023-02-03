package core.basesyntax.transaction;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NegativeValueAmountException;
import core.basesyntax.exceptions.NoExistFruitInStorageException;

public class ReturnTransaction implements OperationHandler {
    @Override
    public void handle(String fruit, int amount) {
        if (amount < 0) {
            throw new NegativeValueAmountException(amount);
        }

        Integer fruitAmount = Storage.fruits.get(fruit);
        if (fruitAmount == null) {
            throw new NoExistFruitInStorageException(fruit);
        }

        Storage.fruits.put(fruit, fruitAmount + amount);
    }
}
