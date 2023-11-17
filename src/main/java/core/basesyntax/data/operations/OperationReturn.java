package core.basesyntax.data.operations;

import core.basesyntax.dao.Item;
import core.basesyntax.dao.StorageDao;

public class OperationReturn implements DataOperation {
    @Override
    public void handle(Item item, StorageDao dao) {
        dao.returnItem(item);
    }
}
