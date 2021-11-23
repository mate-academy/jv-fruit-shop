package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.models.TransactionDto;

public class PurchaseOperationHandlerImpl implements OparationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void apply(TransactionDto transactionDto) {
        String fruitName = transactionDto.getFruitName();
        int quantity = transactionDto.getQuantity();
        storageDao.updateQuantityByName(fruitName, -quantity);
    }
}
