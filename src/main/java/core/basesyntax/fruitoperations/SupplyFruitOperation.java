package core.basesyntax.fruitoperations;

import core.basesyntax.model.FruitBatch;
import core.basesyntax.storage.Storage;

public class SupplyFruitOperation implements FruitOperation {
    private Storage storage;

    public SupplyFruitOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitBatch fruitBatch) {
        if (fruitBatch == null) {
            throw new IllegalArgumentException("Cannot supply null");
        }
        storage.addFruits(fruitBatch);
    }
}
