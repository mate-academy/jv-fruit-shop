package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.model.Transaction;

public class BuyOperation implements Operational {
    private final Storage fruitStorage;

    public BuyOperation(Storage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void operation(Transaction transaction) {
        fruitStorage.removeFromStore(transaction);
    }
}
