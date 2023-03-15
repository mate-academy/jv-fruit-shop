package core.basesyntax.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NotEnoughFruitsInStorageException;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(String fruit, Integer quantity) {
        if (Storage.get(fruit) < quantity) {
            throw new NotEnoughFruitsInStorageException(
                "Not enough fruits in storage. Remained only " + Storage.get(fruit));
        }
        Storage.put(fruit, Storage.get(fruit) - quantity);
    }
}
