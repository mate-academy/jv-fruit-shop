package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.Transaction;

public class Supply implements Operation {
    @Override
    public void provideOperation(Transaction transaction) {
        String key = transaction.getFruitItem();
        Integer quantityToAdd = Integer.parseInt(transaction.getQuantity());
        Storage.storage.put(key, Storage.storage.getOrDefault(key, 0) + quantityToAdd);
    }
}
