package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class BalanceOperation implements FruitOperation {
    @Override
    public void operation(String[] data) {
        Fruit temporaryFruit = new Fruit(data[NAME_INDEX]);
        Storage.FRUIT_STORAGE.put(temporaryFruit, Integer.parseInt(data[QUANTITY_INDEX]));
    }
}
