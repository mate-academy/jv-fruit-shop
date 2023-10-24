package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateStorage(FruitTransaction transaction) {
        validAmount(transaction);
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
