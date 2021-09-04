package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;

public class SupplyOperation implements Operation {
    @Override
    public int apply(Transaction transaction) {
        int oldQuantity = Storage.data.get(transaction.getFruit());
        int newQuantity = transaction.getQuantity() + oldQuantity;
        Storage.data.put(transaction.getFruit(), newQuantity);
        return newQuantity;
    }
}
