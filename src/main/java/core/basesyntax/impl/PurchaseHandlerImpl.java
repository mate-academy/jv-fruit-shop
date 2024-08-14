package core.basesyntax.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseHandlerImpl implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(FruitTransaction transaction) {
        int quantityBefore = fruitDao.get(transaction.getFruit());
        if (quantityBefore < transaction.getQuantity()) {
            throw new RuntimeException("There is not enough fruit in the storage");
        }
        fruitDao.add(transaction.getFruit(), quantityBefore - transaction.getQuantity());
    }
}
