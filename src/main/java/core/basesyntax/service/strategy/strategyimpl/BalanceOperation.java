package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;

public class BalanceOperation implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperation(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public HashMap<String, Integer> apply(FruitTransactionDto dto) {
        return storageDao.add(dto);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "b".equals(dto.operationType());
    }
}
