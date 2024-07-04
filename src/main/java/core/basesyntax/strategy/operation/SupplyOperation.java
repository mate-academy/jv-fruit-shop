package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;

public class SupplyOperation implements OperationHandler {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void operationType(String fruit, int amount) {
        if (storageDao.getFruit(fruit) != null) {
            int newQuantity = storageDao.getFruit(fruit).getQuantity() + amount;
            storageDao.update(fruit, newQuantity);
        } else {
            storageDao.addFruit(new Fruit(fruit, amount));
        }
    }
}
