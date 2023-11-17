package core.basesyntax.db.operations;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.model.Item;

public class OperationPurchase implements DataOperation {
    @Override
    public void handle(Item item, StorageDao dao) {
        dao.purchase(item);
    }
}
