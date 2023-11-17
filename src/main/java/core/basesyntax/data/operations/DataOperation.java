package core.basesyntax.data.operations;

import core.basesyntax.dao.Item;
import core.basesyntax.dao.StorageDao;

public interface DataOperation {
    void handle(Item item, StorageDao dao);
}
