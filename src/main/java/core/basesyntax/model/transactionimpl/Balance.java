package core.basesyntax.model.transactionimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class Balance implements Transaction {
    private final int amount;
    private final String fruitName;

    public Balance(String fruitName, int amount) {
        this.amount = amount;
        this.fruitName = fruitName;
    }

    @Override
    public Integer apply(Storage storage) {
        return storage.setAmount(fruitName, amount);
    }
}
