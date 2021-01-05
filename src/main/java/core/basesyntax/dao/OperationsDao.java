package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopItem;
import core.basesyntax.service.Validator;

public class OperationsDao {

    public void addToStorage(ShopItem item, int quantity) {
        Validator.validate(quantity);
        if (Storage.storage.containsKey(item)) {
            int oldValue = Storage.storage.get(item);
            Storage.storage.put(item, quantity + oldValue);
        } else {
            Storage.storage.put(item, quantity);
        }
    }

    public void subtractFromStorage(ShopItem item, int quantity) {
        if (!Storage.storage.containsKey(item)) {
            throw new RuntimeException("There is no " + item + " in storage");
        }
        int result = Storage.storage.get(item) - quantity;
        Validator.validate(result);
        Storage.storage.put(item, result);
    }
}
