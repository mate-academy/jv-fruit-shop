package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.strategy.BalanceHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseHandler;
import core.basesyntax.service.strategy.ReturnHandler;
import core.basesyntax.service.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyServiceImpl implements OperationStrategyService {
    private final Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
    private final StorageDao storageDao = new StorageDaoImpl();

    {
        map.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(storageDao));
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(storageDao));
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(storageDao));
        map.put(FruitTransaction.Operation.RETURN, new ReturnHandler(storageDao));
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        OperationHandler operationHandler = map.get(operation);
        if (operationHandler == null) {
            throw new RuntimeException("Wrong operation");
        }
        return operationHandler;
    }
}
