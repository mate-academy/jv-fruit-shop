package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationService;
import java.util.NoSuchElementException;

public class SubtractOperationServiceImpl implements OperationService {
    @Override
    public void interact(Transaction transaction) {
        if (Storage.get(transaction.getFruit()) != null) {
            int quantity = Storage.get(transaction.getFruit()) - transaction.getQuantity();
            Storage.add(transaction.getFruit(), quantity);
        } else {
            throw new NoSuchElementException("There is no such fruit in storage");
        }
    }
}
