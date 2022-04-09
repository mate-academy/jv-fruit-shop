package core.basesyntax.stratagy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public interface OperationPerformer {
    public void perform(StorageDao storageDao, FruitTransaction transaction);
}
