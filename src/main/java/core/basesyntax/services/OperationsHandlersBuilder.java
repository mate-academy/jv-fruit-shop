package core.basesyntax.services;

import core.basesyntax.model.Operation;
import core.basesyntax.operationshandlers.BalanceOperationHandler;
import core.basesyntax.operationshandlers.OperationHandler;
import core.basesyntax.operationshandlers.PurchaseOperationHandler;
import core.basesyntax.operationshandlers.ReturnOperationHandler;
import core.basesyntax.operationshandlers.SupplyOperationHandler;
import core.basesyntax.storagedao.StorageDao;
import core.basesyntax.storagedao.StorageDaoImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationsHandlersBuilder {

    public Map<Operation, OperationHandler> getNewOperationHandlersMap() {
        StorageDao storageDao = new StorageDaoImpl();
        HashMap<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE,
                new BalanceOperationHandler(storageDao));
        operationHandlerMap.put(Operation.SUPPLY,
                new SupplyOperationHandler(storageDao));
        operationHandlerMap.put(Operation.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        operationHandlerMap.put(Operation.RETURN,
                new ReturnOperationHandler(storageDao));
        return operationHandlerMap;
    }
}

