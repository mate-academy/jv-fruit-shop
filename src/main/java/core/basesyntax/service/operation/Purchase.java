package core.basesyntax.service.operation;

import core.basesyntax.data.Storage;
import core.basesyntax.model.TransactionDto;

import java.util.Map;

public class Purchase implements Handler {
    @Override
    public boolean apply(TransactionDto transaction) {

        int newQuantity = Storage.storage.get(transaction.getName()) - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Ty lov!");
        }
        Storage.storage.put(transaction.getName(), newQuantity);
        return true;
    }
}
