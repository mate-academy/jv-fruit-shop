package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.Transaction;

public class Supply implements Operation {
    @Override
    public void provideOperation(Transaction transaction) {
        String key = transaction.getFruitItem();
        Integer quantityToAdd = transaction.getQuantity();
        Storage.DateAndQuantityPair pair = Storage.storage.get(key);
        if (pair == null) {
            pair = new Storage.DateAndQuantityPair(transaction.getDate(),
                    transaction.getQuantity());
        } else {
            pair.setQuantity(pair.getQuantity() + quantityToAdd);
            pair.setDate(transaction.getDate());
        }
        Storage.storage.put(key, pair);
    }
}
