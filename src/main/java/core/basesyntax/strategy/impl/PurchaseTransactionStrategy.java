package core.basesyntax.strategy.impl;

import core.basesyntax.exception.NotEnoughFruitsException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionStrategy;

public class PurchaseTransactionStrategy implements TransactionStrategy {
    @Override
    public void processData(FruitTransaction transaction) {
        int currentQuantity = fruitDao.getQuantity(transaction.getFruit());
        if (currentQuantity < transaction.getQuantity()) {
            throw new NotEnoughFruitsException(String.format(
                    "Not enough %s: current quantity - %d, purchase quantity - %d",
                    transaction.getFruit(),
                    currentQuantity,
                    transaction.getQuantity()
            ));
        }
        fruitDao.setQuantity(
                transaction.getFruit(),
                currentQuantity - transaction.getQuantity()
        );
    }
}
