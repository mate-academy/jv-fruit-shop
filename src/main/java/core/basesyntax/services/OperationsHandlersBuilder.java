package core.basesyntax.services;

import core.basesyntax.model.OperationsWithFruits;
import core.basesyntax.operationshandlers.BalanceOperationHandler;
import core.basesyntax.operationshandlers.OperationHandler;
import core.basesyntax.operationshandlers.PurchaseOperationHandler;
import core.basesyntax.operationshandlers.ReturnOperationHandlers;
import core.basesyntax.operationshandlers.SupplyOperationHandler;
import core.basesyntax.storagedao.StorageDao;
import core.basesyntax.storagedao.StorageDaoImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationsHandlersBuilder {

    public Map<OperationsWithFruits, OperationHandler> getNewOperationHandlersMap() {
        StorageDao storageDao = new StorageDaoImpl();
        HashMap<OperationsWithFruits, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationsWithFruits.BALANCE,
                new BalanceOperationHandler(storageDao));
        operationHandlerMap.put(OperationsWithFruits.SUPPLY,
                new SupplyOperationHandler(storageDao));
        operationHandlerMap.put(OperationsWithFruits.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        operationHandlerMap.put(OperationsWithFruits.RETURN,
                new ReturnOperationHandlers(storageDao));
        return operationHandlerMap;
    }
}

