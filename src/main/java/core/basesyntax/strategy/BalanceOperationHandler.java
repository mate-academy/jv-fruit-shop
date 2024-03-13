package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void fruitTransactionHandler(FruitTransaction transaction) {

        FruitStorage.fruitTransactionStorage
                .put(transaction.getFruit(), transaction.getQuantity());
    }
}
