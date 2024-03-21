package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperation(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransactionDto dto) {
        storageDao.add(dto.fruitName(), dto.quantity());
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return dto.operationType() == Operation.BALANCE;
    }

    @Override
    public Operation getOperation() {
        return Operation.BALANCE;
    }
}
