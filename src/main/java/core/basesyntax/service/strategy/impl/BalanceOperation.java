package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;

public class BalanceOperation implements OperationHandler {
    private final StorageDao actionDB;

    public BalanceOperation(StorageDaoImpl actionDB) {
        this.actionDB = actionDB;
    }

    @Override
    public HashMap<String, Integer> apply(FruitTransactionDto dto) {
        return actionDB.add(dto);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "b".equals(dto.operationType());
    }
}
