package core.basesyntax.db.operations;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.model.Item;
import core.basesyntax.model.ItemTransaction;

public class ReturnOperationHandler implements DataOperation {
    @Override
    public void handle(ItemTransaction transaction) {
        dao.returnItem(item);
    }
}
