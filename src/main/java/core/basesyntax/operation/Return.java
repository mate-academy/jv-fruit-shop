package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.Transaction;

public class Return implements Operation {
    @Override
    public void provideOperation(Transaction transaction) {
        String key = transaction.getFruitItem();
        Integer quantityToAdd = transaction.getQuantity();
        Storage.DateAndQuantityPair pair = Storage.storage.get(key);
        pair.setQuantity(pair.getQuantity() + quantityToAdd);
        pair.setDate(transaction.getDate());
        Storage.storage.put(key, pair);
    }
}
