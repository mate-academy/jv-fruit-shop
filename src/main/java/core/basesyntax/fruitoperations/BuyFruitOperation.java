package core.basesyntax.fruitoperations;

import core.basesyntax.model.FruitBatch;
import core.basesyntax.storage.Storage;

public class BuyFruitOperation implements FruitOperation {
    private Storage storage;

    public BuyFruitOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitBatch fruitBatch) {
        if (fruitBatch == null) {
            throw new IllegalArgumentException("Cannot buy null");
        }
        storage.removeFruits(fruitBatch);
    }
}
