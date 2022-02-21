package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public interface FruitOperation {
    Integer NAME_INDEX = 1;
    Integer QUANTITY_INDEX = 2;

    void operation(String[] data);

    default void increaseQuantity(String[] data) {
        Fruit temporaryFruit = new Fruit(data[NAME_INDEX]);
        Storage.FRUIT_STORAGE.put(temporaryFruit,
                Storage.FRUIT_STORAGE.get(temporaryFruit) + Integer.parseInt(data[QUANTITY_INDEX]));
    }

    default void reduceQuantity(String[] data) {
        Fruit temporaryFruit = new Fruit(data[NAME_INDEX]);
        Storage.FRUIT_STORAGE.put(temporaryFruit,
                Storage.FRUIT_STORAGE.get(temporaryFruit) - Integer.parseInt(data[QUANTITY_INDEX]));
    }

    default void createKeyValue(String[] data) {
        Fruit temporaryFruit = new Fruit(data[NAME_INDEX]);
        Storage.FRUIT_STORAGE.put(temporaryFruit, Integer.parseInt(data[QUANTITY_INDEX]));
    }
}
