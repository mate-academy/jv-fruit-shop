package core.basesyntax.service.operationhadler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitsTransaction;

public class BalanceHandler implements TransactionHandler {
    @Override
    public void handleTransaction(FruitsTransaction transaction) {
        FruitStorage.fruitsStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
