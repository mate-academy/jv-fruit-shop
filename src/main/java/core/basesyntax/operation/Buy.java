package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.Transaction;

public class Buy implements Operation {
    @Override
    public void provideOperation(Transaction transaction) {
        String key = transaction.getFruitItem();
        Integer quantityToSubtract = Integer.parseInt(transaction.getQuantity());
        Storage.storage.put(key, Storage.storage.get(key) - quantityToSubtract);
    }
}
