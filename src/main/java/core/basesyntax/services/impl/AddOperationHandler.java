package core.basesyntax.services.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.models.TransactionDto;
import core.basesyntax.services.OperationHandler;

public class AddOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public AddOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void apply(TransactionDto transactionDto) {
        String fruitName = transactionDto.getFruitName();
        int quantity = transactionDto.getQuantity();
        if (storageDao.contains(fruitName)) {
            storageDao.update(fruitName, quantity);
        } else {
            storageDao.add(fruitName, quantity);
        }
    }
}
