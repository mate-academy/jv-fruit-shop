package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopItem;

public class OperationsDao {
    public void addToStorage(ShopItem item, int quantity) {
        validate(quantity);
        if (Storage.storage.containsKey(item)) {
            int oldValue = Storage.storage.get(item);
            Storage.storage.put(item, quantity + oldValue);
        } else {
            Storage.storage.put(item, quantity);
        }
    }

    public void subtractFromStorage(ShopItem item, int quantity) {
        validate(quantity);
        if (!Storage.storage.containsKey(item)) {
            throw new RuntimeException("There is no " + item + " in storage");
        }
        int result = Storage.storage.get(item) - quantity;
        validate(result);
        Storage.storage.put(item, result);
    }

    private void validate(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Negative quantity!");
        }
    }
}
