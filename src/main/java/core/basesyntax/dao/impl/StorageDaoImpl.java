package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Item;
import java.util.List;

public class StorageDaoImpl implements StorageDao {

    @Override
    public Item add(Item item) {
        Storage.items.add(item);
        return item;
    }

    @Override
    public List<Item> getAll() {
        return Storage.items;
    }

    @Override
    public Item get(String name) {
        for (Item item : Storage.items) {
            if (name.equals(item.getName())) {
                return item;
            }
        }
        return null;
    }
}
