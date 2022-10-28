package service.operations;

import dao.StorageDao;

public class PurchaseHandler implements OperationHandler {
    private StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(String fruitName, Integer quantity) {
        if (storageDao.getQuantity(fruitName) < quantity) {
            throw new RuntimeException("There is not enough " + fruitName + " in the storage");
        }
        Integer previousQuantity = storageDao.getQuantity(fruitName);
        Integer newQuantity = previousQuantity - quantity;
        storageDao.setQuantity(fruitName, newQuantity);
    }
}
