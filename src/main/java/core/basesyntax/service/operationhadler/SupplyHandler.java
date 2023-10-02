package core.basesyntax.service.operationhadler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitsTransaction;

public class SupplyHandler implements TransactionHandler {
    @Override
    public void handleTransaction(FruitsTransaction transaction) {
        int currentQuantity = FruitStorage.fruitsStorage.get(transaction.getFruit());
        FruitStorage.fruitsStorage.put(transaction.getFruit(), currentQuantity
                + transaction.getQuantity());
    }
}
