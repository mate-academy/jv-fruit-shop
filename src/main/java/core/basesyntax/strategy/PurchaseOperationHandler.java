package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.get(fruit);
        Storage.put(fruit, Optional.of(currentQuantity - transaction.getQuantity())
                .orElseThrow(NoSuchElementException::new));
    }
}
