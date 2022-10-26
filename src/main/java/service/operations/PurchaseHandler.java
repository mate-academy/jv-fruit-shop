package service.operations;

import dao.StorageDao;

public class PurchaseHandler implements OperationsHandler {
    private StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(String fruitName, Integer quantity) {
        if (storageDao.get(fruitName) < quantity) {
            throw new RuntimeException("There is not enough " + fruitName + " in the storage");
        }
        Integer previousQuantity = storageDao.get(fruitName);
        Integer newQuantity = previousQuantity - quantity;
        storageDao.set(fruitName, newQuantity);
    }
}
