package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        int newQuantity = transaction.getQuantity();
        Storage.getFruits().put(new Fruit(transaction.getName()), newQuantity);
        return newQuantity;
    }
}
