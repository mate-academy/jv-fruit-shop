package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    private static final int MIN_AMOUNT = 0;
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void updateStorage(FruitTransaction transaction) {
        if (transaction.getAmount() < MIN_AMOUNT) {
            throw new RuntimeException("Amount of fruits are less then zero!!!");
        }
        if (!storageDao.isInStorage(transaction.getFruitName())) {
            storageDao.add(new Fruit(transaction.getFruitName()), transaction.getAmount());
        } else {
            Map.Entry<Fruit, Integer> fruitAndAmount = storageDao.get(transaction.getFruitName());
            Integer fruitAmount = fruitAndAmount.getValue();
            Integer fruitAmountFromTransaction = transaction.getAmount();
            fruitAndAmount.setValue(fruitAmount + fruitAmountFromTransaction);
        }
    }
}
