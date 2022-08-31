package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationService;
import java.util.NoSuchElementException;

public class SubtractOperationServiceImpl implements OperationService {
    @Override
    public void interact(Transaction transaction) {
        int quantity;
        if (Storage.get(transaction.getFruit()) != null) {
            quantity = Storage.get(transaction.getFruit()) - transaction.getQuantity();
            Storage.add(transaction.getFruit(), quantity);
        } else {
            throw new NoSuchElementException(transaction.getFruit() + " Can`t subtract null");
        }
    }
}
