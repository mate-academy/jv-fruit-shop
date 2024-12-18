package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.models.FruitTransfer;

public class SupplyHandler implements OperationHandler {
    private final StorageDao fruitDao;

    public SupplyHandler() {
        this.fruitDao = new StorageDaoImpl();
    }

    @Override
    public void performOperation(FruitTransfer fruitTransfer) {
        int storedFruits = fruitDao.getStoredQuantity(fruitTransfer.getFruit());
        int updatedFruitBalance = storedFruits + fruitTransfer.getQuantity();
        fruitDao.addFruit(fruitTransfer.getFruit(), updatedFruitBalance);
    }
}
