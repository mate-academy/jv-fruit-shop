package core.basesyntax.service.operationhadler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitsTransaction;

public class ReturnHandler implements TransactionHandler {
    @Override
    public void handleTransaction(FruitsTransaction transaction) {
        int currentValue = FruitStorage.fruitsStorage.get(transaction.getFruit());
        FruitStorage.fruitsStorage.put(transaction.getFruit(), currentValue
                + transaction.getQuantity());
    }
}
