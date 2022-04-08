package core.basesyntax.stratagy.performers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageDao;
import core.basesyntax.stratagy.OperationPerformer;

public class SetBalanceOperationPerformer implements OperationPerformer {
    @Override
    public void perform(StorageDao storage, FruitTransaction transaction) {
        storage.set(transaction.getFruit(), transaction.getQuantity());
    }
}
