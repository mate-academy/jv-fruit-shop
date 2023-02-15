package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandlerImpl implements Handler {
    @Override
    public void handle(FruitTransaction transaction) {
        int allAmount = FruitStorage.fruitStorage.get(transaction.getFruit())
                - transaction.getQuantity();
        if (allAmount < 0) {
            throw new RuntimeException("Don't have this fruit");
        }
        FruitStorage.fruitStorage.put(transaction.getFruit(), allAmount);
    }
}
