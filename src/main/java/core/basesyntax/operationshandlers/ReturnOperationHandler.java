package core.basesyntax.operationshandlers;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storagedao.StorageDao;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateValueInStorage(FruitTransaction transaction) {
        validAmount(transaction);
        if (storageDao.isInStorage(transaction.getFruitName())) {
            Map.Entry<Fruit,Integer> fruitAndQuantity = storageDao.get(transaction.getFruitName());
            fruitAndQuantity.setValue(fruitAndQuantity.getValue() + transaction.getQuantity());
        } else {
            storageDao.add(new Fruit(transaction.getFruitName()), transaction.getQuantity());
        }
    }
}
