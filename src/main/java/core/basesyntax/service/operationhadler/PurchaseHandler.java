package core.basesyntax.service.operationhadler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitsTransaction;

public class PurchaseHandler implements TransactionHandler {
    @Override
    public void handleTransaction(FruitsTransaction transaction) {
        int result = FruitStorage.fruitsStorage.get(transaction.getFruit())
                - transaction.getQuantity();
        if (result >= 0) {
            FruitStorage.fruitsStorage.put(transaction.getFruit(), result);
        } else {
            throw new RuntimeException("Not enough fruits!");
        }
    }
}
