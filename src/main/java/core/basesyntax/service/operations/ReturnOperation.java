package core.basesyntax.service.operations;

import core.basesyntax.infrastructure.db.Storage;
import core.basesyntax.service.FruitTransaction;
import java.util.NoSuchElementException;

public class ReturnOperation implements OperationHandler {
    @Override
    public void run(FruitTransaction fruitTransaction) {
        if (Storage.STORAGE.get(fruitTransaction.getFruit()) == null) {
            throw new NoSuchElementException("Can't find fruit: " + fruitTransaction.getFruit());
        }
        Storage.STORAGE.replace(fruitTransaction.getFruit(),
                Storage.STORAGE.get(fruitTransaction.getFruit()) + fruitTransaction.getQuantity());
    }
}
