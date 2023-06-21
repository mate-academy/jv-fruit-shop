package core.basesyntax.dao;

import core.basesyntax.model.Item;
import java.util.List;

public interface StorageDao {

    Item add(Item item);

    Item get(String name);

    List<Item> getAll();
}
