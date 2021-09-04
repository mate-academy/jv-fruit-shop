package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;

public class BalanceOperation implements Operation {
    @Override
    public int apply(Transaction transaction) {
        int newQuantity = transaction.getQuantity();
        Storage.data.put(transaction.getFruit(), newQuantity);
        return newQuantity;
    }
}
