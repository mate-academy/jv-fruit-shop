package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.NegativeBalanceException;
import core.basesyntax.service.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperation(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransactionDto dto) {
        Integer currentQuantity = storageDao.get(dto.fruitName());
        if (currentQuantity == null) {
            throw new NegativeBalanceException("Trying to return fruits "
                    + dto.fruitName()
                    + " but there was no fruit in balance or supply which were purchased");
        }
        int newQuantity = currentQuantity + dto.quantity();
        storageDao.add(dto.fruitName(), newQuantity);
    }

}
