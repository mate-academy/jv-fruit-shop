package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class PurchaseTransactionService implements TransactionService {
    @Override
    public void process(FruitTransaction transaction) {
        int currentQuantity = dao.getQuantity(transaction.getFruit());
        if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Balance of fruit %s - %d is not enough to purchase %d"
                    .formatted(transaction.getFruit(), currentQuantity, transaction.getQuantity()));
        }
        dao.setQuantity(transaction.getFruit(), currentQuantity - transaction.getQuantity());
    }
}
