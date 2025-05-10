package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handlerOperation(FruitTransaction transaction) {
        int quantityInTransaction = transaction.getQuantity();
        FruitStorage.fruitTransactionStorage.put(transaction.getFruit(),
                FruitStorage.getQuantity(transaction.getFruit())
                        + quantityInTransaction);
    }
}
