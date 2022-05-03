package service.impl;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import service.OperationHandlerStrategy;
import service.strategy.BalanceOperationHandler;
import service.strategy.OperationHandler;
import service.strategy.PurchaseOperationHandler;
import service.strategy.ReturnOperationHandler;
import service.strategy.SupplyOperationHandler;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
    private final StorageDao storageDao = new StorageDaoImpl();

    {
        map.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(storageDao));
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(storageDao));
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(storageDao));
        map.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler(storageDao));
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return map.get(operation);
    }
}
