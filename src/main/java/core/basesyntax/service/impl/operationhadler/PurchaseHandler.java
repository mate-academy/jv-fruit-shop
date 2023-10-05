package core.basesyntax.service.impl.operationhadler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int result = FruitStorage.fruitsStorage.get(transaction.getFruit())
                - transaction.getQuantity();
        if (result >= 0) {
            FruitStorage.fruitsStorage.put(transaction.getFruit(), result);
        } else {
            throw new RuntimeException("Not enough fruits!");
        }
    }
}
