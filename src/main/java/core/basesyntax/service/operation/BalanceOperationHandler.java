package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImp;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    public static final int INVALID_QUANTITY_MARKER = 0;
    private final FruitStorageDao fruitStorageDao;

    public BalanceOperationHandler() {
        this.fruitStorageDao = new FruitStorageDaoImp();
    }

    @Override
    public void updateBalance(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < INVALID_QUANTITY_MARKER) {
            throw new RuntimeException("Balance cann`t be negative");
        }
        Fruit fruit = fruitStorageDao.get(fruitTransaction.getFruit());
        fruit.setQuantity(fruitTransaction.getQuantity());
    }
}
