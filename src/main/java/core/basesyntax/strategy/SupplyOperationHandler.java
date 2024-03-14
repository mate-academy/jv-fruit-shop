package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void fruitTransactionHandler(FruitTransaction transaction) {
        int quantityInTransaction = transaction.getQuantity();
        FruitStorage.fruitTransactionStorage.put(transaction.getFruit(),
                FruitStorage.getQuantity(transaction.getFruit())
                        + quantityInTransaction);
    }
}
