package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.model.Transaction;

public class SupplyAndReturnOperation implements Operational {
    private final Storage fruitStorage;

    public SupplyAndReturnOperation(Storage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void operation(Transaction transaction) {
        fruitStorage.addToStore(transaction);
    }
}
