package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;

public class ReturnHandler implements OperationHandler {
    private final StorageDao fruitDao;
    private FruitTransfer fruitTransfer;

    public ReturnHandler() {
        this.fruitDao = new StorageDaoImpl();
    }

    @Override
    public void setFruitTransfer(FruitTransfer fruitTransfer) {
        this.fruitTransfer = fruitTransfer;
    }

    @Override
    public void makeOperation() {
        int updatedFruitBalance;
        int storedFruits = fruitDao.getStoredQuantity(this.fruitTransfer.getFruit());
        updatedFruitBalance = storedFruits + this.fruitTransfer.getQuantity();
        fruitDao.addFruit(this.fruitTransfer.getFruit(), updatedFruitBalance);
    }
}
