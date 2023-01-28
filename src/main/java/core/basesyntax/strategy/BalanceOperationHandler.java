package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        int newQuantity = transaction.getQuantity();
        Storage.data.put(transaction.getFruit(), newQuantity);
        return newQuantity;
    }
}
