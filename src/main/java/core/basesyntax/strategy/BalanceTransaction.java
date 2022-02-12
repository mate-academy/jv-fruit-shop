package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class BalanceTransaction implements OperationTransaction {
    @Override
    public void operation(String fruitName, int fruitQuantity) {
        Storage.fruitMap.put(fruitName, fruitQuantity);
    }
}
