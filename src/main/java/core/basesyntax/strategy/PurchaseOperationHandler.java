package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.models.TransactionDto;
import core.basesyntax.services.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void apply(TransactionDto transactionDto) {
        String fruitName = transactionDto.getFruitName();
        int quantity = transactionDto.getQuantity();
        storageDao.updateQuantityByName(fruitName, -quantity);
    }
}
