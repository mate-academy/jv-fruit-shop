package core.basesyntax.service.operation;

import core.basesyntax.data.Storage;
import core.basesyntax.model.TransactionDto;

public class Add implements Handler {
    @Override
    public boolean apply(TransactionDto transaction) {
        if (Storage.storage.get(transaction.getName()) == null) {
            Storage.storage.put(transaction.getName(), transaction.getQuantity());
        } else {
            int newQuantity = transaction.getQuantity()
                    + Storage.storage.get(transaction.getName());
            Storage.storage.put(transaction.getName(), newQuantity);
        }
        return true;
    }
}
