package core.basesyntax.fruitstoreoperation;

import core.basesyntax.Storage;
import core.basesyntax.model.InputDataModel;

public class ReturnFruitOperation implements FruitStoreOperation {
    private Storage storage;

    public ReturnFruitOperation() {
        this.storage = new Storage();
    }

    public void doOperation(InputDataModel product, int amount) {
        storage.addFruitProduct(product, amount);
    }
}
