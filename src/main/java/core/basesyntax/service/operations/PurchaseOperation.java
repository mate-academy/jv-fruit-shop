package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class PurchaseOperation implements FruitOperation {
    @Override
    public void operation(String[] data) {
        Fruit temporaryFruit = new Fruit(data[NAME_INDEX]);
        Storage.FRUIT_STORAGE.replace(temporaryFruit,
                Storage.FRUIT_STORAGE.get(temporaryFruit) - Integer.parseInt(data[QUANTITY_INDEX]));
    }
}
