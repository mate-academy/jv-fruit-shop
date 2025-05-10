package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperation(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransactionDto dto) {
        Integer currentQuantity = storageDao.get(dto.fruitName());
        int quantityReturn = (currentQuantity == null) ? (dto.quantity())
                : (currentQuantity + dto.quantity());
        storageDao.add(dto.fruitName(), quantityReturn);
    }
}
