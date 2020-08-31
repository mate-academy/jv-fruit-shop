package core.basesyntax.fruitoperations;

import core.basesyntax.model.FruitBatch;
import core.basesyntax.storage.Storage;

public class ReturnFruitOperation implements FruitOperation {
    private Storage storage;

    public ReturnFruitOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitBatch fruitBatch) {
        if (fruitBatch == null) {
            throw new IllegalArgumentException("Cannot return null");
        }
        storage.addFruits(fruitBatch);
    }
}
