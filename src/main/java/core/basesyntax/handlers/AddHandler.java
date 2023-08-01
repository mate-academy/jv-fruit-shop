package core.basesyntax.handlers;

import core.basesyntax.storage.Storage;

public class AddHandler {
    public static void addToStorage(String fruit, int quantity) {
        Storage.storage.merge(fruit, quantity, Integer::sum);
    }
}
