package core.basesyntax.operations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public Integer getHandler(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("Fruit transaction is null "
                    + fruitTransaction);
        }
        if (!fruitTransaction.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
            throw new RuntimeException("Can' find balance "
                    + fruitTransaction);
        }
        storageDao.add(fruitTransaction);
        return fruitTransaction.getQuantity();
    }
}
