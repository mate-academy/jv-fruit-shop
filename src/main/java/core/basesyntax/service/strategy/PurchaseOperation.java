package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDaoImpl;

public class PurchaseOperation implements Operations {
    private StorageDaoImpl storageDao = new StorageDaoImpl();

    @Override
    public void applyOperation(String fruitName, Integer amount) {
        storageDao.addProductCount(fruitName, storageDao.getProductCount(fruitName) - amount);
    }
}
