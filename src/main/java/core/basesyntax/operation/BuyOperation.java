package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.model.Transaction;

public class BuyOperation implements Operational {

    @Override
    public void operation(Transaction transaction, Storage fruitStorage) {
        fruitStorage.removeFromStore(transaction);
    }
}
