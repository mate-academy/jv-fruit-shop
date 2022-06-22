package dao;

import db.Storage;
import service.OperationService;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void addNewFruit(String fruit, int quantity) {
        Storage.put(fruit, quantity);
    }

    @Override
    public void changeQuantityOfFruit(String fruit, int quantity, OperationService operation) {
        if (Storage.get(fruit) == null) {
            addNewFruit(fruit, quantity);
            return;
        }
        Storage.put(fruit, operation.getActionByOperation(quantity).applyAsInt(Storage.get(fruit)));
    }

}
