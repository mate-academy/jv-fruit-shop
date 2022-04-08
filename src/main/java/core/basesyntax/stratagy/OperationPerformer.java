package core.basesyntax.stratagy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageDao;

public interface OperationPerformer {
    public void perform(StorageDao storageDao, FruitTransaction transaction);
}
