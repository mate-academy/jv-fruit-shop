package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;

public class SupplyOperation implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperation(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransactionDto dto) {
        HashMap<String, Integer> fruitValue = storageDao.get(dto.fruitName());
        int quantityReturn = (fruitValue == null) ? (dto.quantity())
                : (fruitValue.get(dto.fruitName()) + dto.quantity());
        storageDao.add(dto.fruitName(), quantityReturn);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return dto.operationType() == Operation.SUPPLY;
    }
}
