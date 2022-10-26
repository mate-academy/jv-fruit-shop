package service.operations;

import dao.StorageDao;

public class ReturnHandler implements OperationsHandler {
    private StorageDao storageDao;

    public ReturnHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(String fruitName, Integer quantity) {
        Integer previousQuantity = storageDao.get(fruitName);
        Integer newQuantity = previousQuantity + quantity;
        storageDao.set(fruitName, newQuantity);
    }
}
