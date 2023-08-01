package core.basesyntax.handlers;

import core.basesyntax.storage.Storage;

public class AddFruitsToStorage {
    public static void addToStorage(String fruit, int quantity) {
        int currentQuantity = 0;
        if (Storage.storage.get(fruit) != null) {
            currentQuantity = Storage.storage.get(fruit);
        }
        Storage.storage.put(fruit, currentQuantity + quantity);
    }
}
