package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;

public class BalanceHandler implements OperationHandler {
    private final StorageDao fruitDao;
    private FruitTransfer fruitTransfer;

    public BalanceHandler() {
        this.fruitDao = new StorageDaoImpl();
    }

    @Override
    public void setFruitTransfer(FruitTransfer fruitTransfer) {
        this.fruitTransfer = fruitTransfer;
    }

    @Override
    public void makeOperation() {
        fruitDao.addFruit(this.fruitTransfer.getFruit(), this.fruitTransfer.getQuantity());
    }
}
