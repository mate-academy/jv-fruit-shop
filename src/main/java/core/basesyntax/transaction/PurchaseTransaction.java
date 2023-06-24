package core.basesyntax.transaction;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NegativeValueAmountException;
import core.basesyntax.exceptions.NoExistFruitInStorageException;

public class PurchaseTransaction implements OperationHandler {
    @Override
    public void handle(String fruit, int amount) {
        if (amount < 0) {
            throw new NegativeValueAmountException(amount);
        }

        Integer fruitAmount = Storage.fruits.get(fruit);
        if (fruitAmount == null) {
            throw new NoExistFruitInStorageException(fruit);
        }
        if (fruitAmount < amount) {
            throw new RuntimeException(
                    "Impossible purchase more fruit then exit in storage. In storage: "
                    + fruitAmount
                    + ", purchase amount: "
                    + amount
            );
        }

        Storage.fruits.put(fruit, fruitAmount - amount);
    }
}
