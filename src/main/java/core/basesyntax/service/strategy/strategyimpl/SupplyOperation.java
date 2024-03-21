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
        try {
            HashMap<String, Integer> oldFrutitValue = storageDao.get(dto);
            FruitTransactionDto newFruitValue = new FruitTransactionDto(dto.operationType(),
                    dto.fruitName(),
                    oldFrutitValue.get(dto.fruitName()) + dto.quantity());
            return storageDao.change(newFruitValue);
        } catch (NullPointerException e) {
            return storageDao.add(dto);
        }
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "s".equals(dto.operationType());
    }
}
