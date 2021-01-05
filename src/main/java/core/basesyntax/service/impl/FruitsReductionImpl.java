package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruits;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationWithFruits;
import java.util.Optional;

public class FruitsReductionImpl implements OperationWithFruits {
    private static final int NOTHING = 0;

    @Override
    public void apply(Transaction transaction) {
        Fruits fruit = transaction.getFruitName();
        Integer amount = Optional.ofNullable(Storage.storage.get(fruit)).orElse(NOTHING);
        int reductionResult = amount - transaction.getAmount();
        if (reductionResult < NOTHING) {
            throw new RuntimeException("Balance can`t be negative");
        }
        Storage.storage.put(fruit, reductionResult);
    }
}
