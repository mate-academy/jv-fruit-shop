package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.models.FruitTransfer;

public class BalanceHandler implements OperationHandler {
    private final StorageDao fruitDao;

    public BalanceHandler() {
        this.fruitDao = new StorageDaoImpl();
    }

    @Override
    public void performOperation(FruitTransfer fruitTransfer) {
        if (fruitTransfer.getQuantity() < 0) {
            throw new RuntimeException("It's not allowed negative amount. Amount is "
                    + fruitTransfer.getQuantity());
        }

        fruitDao.addFruit(fruitTransfer.getFruit(), fruitTransfer.getQuantity());
    }
}
