package core.basesyntax.model.transactionimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class Purchase implements Transaction {
    private final int amount;
    private final String fruitName;

    public Purchase(String fruitName, int amount) {
        this.amount = amount;
        this.fruitName = fruitName;
    }

    @Override
    public Integer apply(Storage storage) {
        int newAmount = storage.getAmount(fruitName) - amount;
        if (newAmount < 0) {
            throw new RuntimeException("Not enough " + fruitName);
        }
        return storage.setAmount(fruitName, newAmount);
    }
}
