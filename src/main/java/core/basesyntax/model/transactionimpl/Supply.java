package core.basesyntax.model.transactionimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class Supply implements Transaction {
    private final int amount;
    private final String fruitName;

    public Supply(String fruitName, int amount) {
        this.amount = amount;
        this.fruitName = fruitName;
    }

    @Override
    public Integer apply(Storage storage) {
        int newAmount = storage.getAmount(fruitName) + amount;
        return storage.setAmount(fruitName, newAmount);
    }
}
