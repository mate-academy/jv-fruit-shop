package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationService;
import java.util.NoSuchElementException;

public class SubtractOperationServiceImpl implements OperationService {
    @Override
    public void interact(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (Storage.get(fruit) != null) {
            int quantity = Storage.get(fruit) - transaction.getQuantity();
            Storage.add(fruit, quantity);
        } else {
            throw new NoSuchElementException("There is no such fruit in storage");
        }
    }
}
