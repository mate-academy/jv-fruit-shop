package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.FruitStorageDao;

public class SupplyOperation implements OperationHandler {
    private final FruitStorageDao storageDao;

    public SupplyOperation(FruitStorageDao storageDao) {
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
