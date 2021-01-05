package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruits;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationWithFruits;
import java.util.Optional;

public class FruitsAdditionImpl implements OperationWithFruits {
    private static final int NOTHING = 0;

    @Override
    public void apply(Transaction transaction) {
        Fruits fruit = transaction.getFruitName();
        Integer amount = Optional.ofNullable(Storage.storage.get(fruit)).orElse(NOTHING);
        Storage.storage.put(fruit, amount + transaction.getAmount());
    }
}
