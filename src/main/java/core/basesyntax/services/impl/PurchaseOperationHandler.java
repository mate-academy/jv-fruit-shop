package core.basesyntax.services.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.exceptions.NotEnoughFruitsException;
import core.basesyntax.models.TransactionDto;
import core.basesyntax.services.OperationHandler;
import java.util.Optional;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void apply(TransactionDto transactionDto) {
        String fruitName = transactionDto.getFruitName();
        int quantityToPurchase = transactionDto.getQuantity();
        Optional<Integer> currentQuantity = storageDao.get(fruitName);
        if (currentQuantity.isEmpty()
                || currentQuantity.get() < quantityToPurchase) {
            throw new NotEnoughFruitsException(
                    "Attempt to purchase:" + quantityToPurchase + System.lineSeparator()
                    + "But exist: " + currentQuantity.orElse(null));
        }
        storageDao.update(fruitName, -quantityToPurchase);
    }
}
