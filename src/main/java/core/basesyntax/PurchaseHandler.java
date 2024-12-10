package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;

public class PurchaseHandler implements OperationHandler {
    private final StorageDao fruitDao;
    private FruitTransfer fruitTransfer;

    public PurchaseHandler() {
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
        if (this.fruitTransfer.getQuantity() > storedFruits) {
            throw new RuntimeException("Invalid quantity, " + this.fruitTransfer.getFruit()
                    + " balance is "
                    + storedFruits);
        }
        updatedFruitBalance = storedFruits - this.fruitTransfer.getQuantity();
        fruitDao.removeFruitLot(this.fruitTransfer.getFruit());
        fruitDao.addFruit(this.fruitTransfer.getFruit(), updatedFruitBalance);
    }
}
