package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationService;

public class AddOperationServiceImpl implements OperationService {
    @Override
    public void interact(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (Storage.get(transaction.getFruit()) != null) {
            int quantity = Storage.get(fruit) + transaction.getQuantity();
            Storage.add(fruit, quantity);
        } else {
            Storage.add(fruit, transaction.getQuantity());
        }
    }
}
