package core.basesyntax.operationhandlers;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class SubtractHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        String fruit = fruitTransaction.getFruit();
        int quantityForSale = fruitTransaction.getQuantity();
        int quantityAvailable = fruitStorageDao.get(fruit);
        if (quantityAvailable < quantityForSale) {
            throw new RuntimeException("You don't have enough goods");
        }
        if (quantityForSale < 0) {
            throw new RuntimeException("Purchase of a negative quantity of goods is impossible");
        }
        fruitStorageDao.add(fruit, quantityAvailable - quantityForSale);
    }
}
