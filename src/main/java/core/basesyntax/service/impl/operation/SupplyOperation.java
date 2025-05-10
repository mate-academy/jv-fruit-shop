package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.FruitStorageDao;
import java.util.Objects;

public class SupplyOperation implements OperationHandler {
    private final FruitStorageDao storageDao;

    public SupplyOperation(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(String fruitName, Integer quantity) {
        Integer previousQuantity;
        Integer currentQuantity = storageDao.getQuantity(fruitName);

        previousQuantity = Objects.requireNonNullElse(currentQuantity, 0);

        Integer newQuantity = previousQuantity + quantity;
        storageDao.setQuantity(fruitName, newQuantity);
    }
}
