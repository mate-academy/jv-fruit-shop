package core.basesyntax.strategy;

import core.basesyntax.dao.Storage;
import core.basesyntax.dto.Transaction;

public class SupplyOperation implements Operation {
    @Override
    public int apply(Transaction transaction) {
        Storage.map.computeIfAbsent(transaction.getFruit().getFruitName(),
                k -> transaction.getQuantity());
        int oldQuantity = Storage.map.get(transaction.getFruit().getFruitName());
        int newQuantity = transaction.getQuantity() + oldQuantity;
        Storage.map.put(transaction.getFruit().getFruitName(), newQuantity);
        return newQuantity;
    }
}
