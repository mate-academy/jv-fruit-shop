package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationService;

public class AddOperationServiceImpl implements OperationService {

    @Override
    public void interact(Transaction transaction) {
        int quantity;
        if (Storage.get(transaction.getFruit()) != null) {
            quantity = Storage.get(transaction.getFruit()) + transaction.getQuantity();
            Storage.add(transaction.getFruit(), quantity);
        } else {
            Storage.add(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
