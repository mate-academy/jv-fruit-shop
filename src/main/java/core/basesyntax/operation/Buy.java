package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.Transaction;
import java.time.LocalDate;

public class Buy implements Operation {
    @Override
    public void provideOperation(Transaction transaction) {
        String key = transaction.getFruitItem();
        Integer quantityToSubtract = transaction.getQuantity();
        Storage.DateAndQuantityPair pair = Storage.storage.get(key);
        LocalDate dateFromTransaction = transaction.getDate();
        LocalDate dateFromStorage = pair.getDate();
        if (dateFromStorage.isBefore(dateFromTransaction)) {
            throw new RuntimeException("All fruits are out of date. We are sorry");
        }
        if (transaction.getQuantity() > pair.getQuantity()) {
            throw new RuntimeException("We are out of this fruit. You can buy another one");
        }
        pair.setQuantity(pair.getQuantity() - quantityToSubtract);
        Storage.storage.put(key, pair);
    }
}
