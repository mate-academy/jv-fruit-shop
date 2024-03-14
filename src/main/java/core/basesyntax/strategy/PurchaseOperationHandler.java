package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void fruitTransactionHandler(FruitTransaction transaction) {
        int quantityInTransaction = transaction.getQuantity();
        if (quantityInTransaction <= FruitStorage.getQuantity(transaction.getFruit())) {
            FruitStorage.fruitTransactionStorage.put(transaction.getFruit(),
                    FruitStorage.getQuantity(transaction.getFruit())
                            - quantityInTransaction);
        } else {
            throw new RuntimeException("Not enough quantity for sell: fruit - "
                    + transaction.getFruit()
                    + " | quantity - "
                    + transaction.getQuantity());
        }
    }
}
