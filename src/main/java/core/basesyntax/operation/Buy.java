package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.Transaction;
import java.time.LocalDate;

public class Buy implements Operation {
    @Override
    public void provideOperation(Transaction transaction) {
        String key = transaction.getFruitItem();
        if (Storage.storage.containsKey(key)) {
            LocalDate dateFromTransaction = transaction.getDate();
            Integer quantityToSubtract = transaction.getQuantity();
            extractFromStorage(quantityToSubtract, dateFromTransaction, key);
        } else {
            throw new RuntimeException("We do not have this fruit. Try to buy another");
        }
    }

    private void extractFromStorage(Integer quantity, LocalDate date, String key) {
        Storage.DateAndQuantityPair pair = Storage.storage.get(key);
        if (pair.getAllQuantityByDate(date) < quantity) {
            throw new RuntimeException("We are out of this fruit. You can buy another one");
        }
        while (pair != null) {
            if (pair.getDate().isAfter(date)) {
                if (pair.getQuantity() >= quantity) {
                    pair.setQuantity(pair.getQuantity() - quantity);
                    return;
                }
                int difference = quantity - pair.getQuantity();
                pair.setQuantity(0);
                quantity = difference;
            }
            if (quantity == 0) {
                Storage.storage.put(key, pair);
                return;
            }
            pair = pair.getNext();
        }
    }
}
