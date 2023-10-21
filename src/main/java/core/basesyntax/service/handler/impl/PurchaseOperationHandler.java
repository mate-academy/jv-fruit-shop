package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int MIN_AMOUNT = 0;
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void updateStorage(FruitTransaction transaction) {
        if (validAmountOfFruit(transaction)) {
            Map.Entry<Fruit, Integer> fruitAndAmount = storageDao.get(transaction.getFruitName());
            Integer fruitAmount = fruitAndAmount.getValue();
            Integer fruitAmountFromTransaction = transaction.getAmount();
            fruitAndAmount.setValue(fruitAmount - fruitAmountFromTransaction);
        }
    }

    private boolean validAmountOfFruit(FruitTransaction transaction) {
        if (transaction.getAmount() < MIN_AMOUNT) {
            throw new RuntimeException("Amount are less then zero!!!");
        }
        if (!storageDao.isInStorage(transaction.getFruitName())) {
            throw new RuntimeException("There is no such fruit!!!");
        }
        if (storageDao.get(transaction.getFruitName()).getValue() < transaction.getAmount()) {
            throw new RuntimeException("Amount of fruit isn't enough!!!");
        }
        return true;
    }
}
