package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImp;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    public static final int INVALID_QUANTITY_MARKER = 0;
    private final FruitStorageDao fruitStorageDao;

    public PurchaseOperationHandler() {
        this.fruitStorageDao = new FruitStorageDaoImp();
    }

    @Override
    public void updateBalance(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < INVALID_QUANTITY_MARKER) {
            throw new RuntimeException("Purchase cann`t be negative");
        }
        Fruit fruit = fruitStorageDao.get(fruitTransaction.getFruit());
        int fruitBalance = fruit.getQuantity();
        if (fruitTransaction.getQuantity() > fruitBalance) {
            throw new RuntimeException("Purchase cann`t be more than previous balance");
        }
        fruit.setQuantity(fruitBalance - fruitTransaction.getQuantity());
    }
}
