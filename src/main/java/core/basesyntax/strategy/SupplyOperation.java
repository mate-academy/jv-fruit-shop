package core.basesyntax.strategy;

import core.basesyntax.dao.Storage;
import core.basesyntax.dto.Transaction;

public class SupplyOperation implements Operation {
    @Override
    public int apply(Transaction transaction) {
        Storage.fruitStorageMap.computeIfAbsent(transaction.getFruit().getFruitName(),
                k -> transaction.getQuantity());
        int oldQuantity = Storage.fruitStorageMap.get(transaction.getFruit().getFruitName());
        int newQuantity = transaction.getQuantity() + oldQuantity;
        Storage.fruitStorageMap.put(transaction.getFruit().getFruitName(), newQuantity);
        return newQuantity;
    }
}
