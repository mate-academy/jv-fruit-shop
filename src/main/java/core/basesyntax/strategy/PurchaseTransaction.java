package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseTransaction implements OperationTransaction {
    @Override
    public void operation(String fruitName, int fruitQuantity) {
        Storage.fruitMap.put(fruitName,
                Storage.fruitMap.getOrDefault(fruitName, 0) - fruitQuantity);
    }
}
