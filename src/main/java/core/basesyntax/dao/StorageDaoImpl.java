package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.CantGetFruitException;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruit, Integer quantity) {
        Storage.getStorage().merge(fruit, quantity, Integer::sum);
    }

    @Override
    public void take(String fruit, Integer quantity) {
        Integer oldQuantity = Storage.getStorage().get(fruit);
        if (oldQuantity == null) {
            throw new CantGetFruitException("There isn't " + fruit + " in storage");
        }
        if (oldQuantity < quantity) {
            throw new CantGetFruitException(
                    String.format("Can't get %s %s from storage, available only %s %s",
                            quantity, fruit, oldQuantity, fruit));
        }
        Storage.getStorage().put(fruit, oldQuantity - quantity);
    }
}
