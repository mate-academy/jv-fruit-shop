package core.basesyntax.db.operations;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.model.Item;

public interface DataOperation {
    void handle(Item item, StorageDao dao);
}
