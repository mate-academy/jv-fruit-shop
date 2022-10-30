package service.operations;

import dao.StorageDao;

public class SupplyHandler implements OperationHandler {
    private StorageDao storageDao;

    public SupplyHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(String fruitName, Integer quantity) {
        Integer previousQuantity;
        try {
            previousQuantity = storageDao.getQuantity(fruitName);
        } catch (RuntimeException e) {
            previousQuantity = 0;
        }
        Integer newQuantity = previousQuantity + quantity;
        storageDao.setQuantity(fruitName, newQuantity);
    }
}
