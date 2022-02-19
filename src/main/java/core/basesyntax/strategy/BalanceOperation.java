package core.basesyntax.strategy;

import core.basesyntax.dao.Storage;
import core.basesyntax.dto.Transaction;

public class BalanceOperation implements Operation {
    @Override
    public int apply(Transaction transaction) {
        int newQuantity = transaction.getQuantity();
        Storage.fruitStorage.put(transaction.getFruit().getFruitName(), newQuantity);
        return newQuantity;
    }
}
