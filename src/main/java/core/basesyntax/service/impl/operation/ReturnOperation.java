package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.FruitStorageDao;

public class ReturnOperation implements OperationHandler {
    private final FruitStorageDao storageDao;

    public ReturnOperation(FruitStorageDao storageDao) {
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
