package core.basesyntax.operationshandlers;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storagedao.StorageDao;

import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateValueInStorage(FruitTransaction transaction) {
        validAmount(transaction);
        if (storageDao.isInStorage(transaction.getFruitName())) {
            Map.Entry<Fruit,Integer> fruitAndQuantity = storageDao.get(transaction.getFruitName());
            fruitAndQuantity.setValue(transaction.getQuantity() + fruitAndQuantity.getValue());
        } else {
            storageDao.add(new Fruit(transaction.getFruitName()), transaction.getQuantity());
        }
    }
}
