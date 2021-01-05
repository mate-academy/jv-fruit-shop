package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class SubtractionStrategy implements OperationStrategy {
    @Override
    public void apply(Transaction transaction) {
        int quantity = Storage.balance.get(transaction.getFruit());
        if (transaction.getQuantity() < 0 || quantity < transaction.getQuantity()) {
            throw new RuntimeException("Buyers will not be able to buy " + transaction.getQuantity()
                    + " bananas, because they are only " + quantity + " units in stock.");
        }
        Storage.balance.put(transaction.getFruit(), quantity - transaction.getQuantity());
    }
}
