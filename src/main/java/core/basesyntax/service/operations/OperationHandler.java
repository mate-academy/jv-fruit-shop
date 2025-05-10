package core.basesyntax.service.operations;

import core.basesyntax.infrastructure.db.Storage;
import core.basesyntax.service.FruitTransaction;
import java.util.NoSuchElementException;

public interface OperationHandler {
    void run(FruitTransaction fruitTransaction);

    default void isFruitAvailable(FruitTransaction fruitTransaction) {
        if (Storage.STORAGE.get(fruitTransaction.getFruit()) == null) {
            throw new NoSuchElementException("Can't find fruit: " + fruitTransaction.getFruit());
        }
    }

}
