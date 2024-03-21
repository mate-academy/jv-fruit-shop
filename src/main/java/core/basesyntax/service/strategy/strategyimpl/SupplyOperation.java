package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;

public class SupplyOperation implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperation(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public HashMap<String, Integer> apply(FruitTransactionDto dto) {
        HashMap<String, Integer> fruitValue = storageDao.get(dto.fruitName());
        int quantityReturn;
        quantityReturn = (fruitValue == null) ? (dto.quantity())
                : (fruitValue.get(dto.fruitName()) + dto.quantity());
        return storageDao.add(dto.fruitName(), quantityReturn);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "s".equals(dto.operationType());
    }
}
