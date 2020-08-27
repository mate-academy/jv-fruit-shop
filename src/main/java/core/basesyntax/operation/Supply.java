package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.Transaction;

public class Supply implements Operation {
    @Override
    public void provideOperation(Transaction transaction) {
        String key = transaction.getFruitItem();
        Integer quantityToAdd = transaction.getQuantity();
        Storage.DateAndQuantityPair pair;
        if (Storage.storage.containsKey(key)) {
            pair = Storage.storage.get(key);
            while (pair.getNext() != null) {
                if (pair.getDate().equals(transaction.getDate())) {
                    pair.setQuantity(pair.getQuantity() + quantityToAdd);
                    return;
                }
                pair = pair.getNext();
            }
            pair.setNext(new Storage.DateAndQuantityPair(transaction.getDate(), quantityToAdd));
        } else {
            pair = new Storage.DateAndQuantityPair(transaction.getDate(),
                    quantityToAdd);
        }
        Storage.storage.put(key, pair);
    }
}
