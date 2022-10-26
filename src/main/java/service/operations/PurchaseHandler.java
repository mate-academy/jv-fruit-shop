package service.operations;

import dao.StorageDao;

public class PurchaseHandler implements OperationsHandler {
    private StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(String fruitName, Integer quantity) {
        Integer previousQuantity = storageDao.get(fruitName);
        Integer newQuantity = previousQuantity - quantity;
        storageDao.set(fruitName, newQuantity);
    }
}
