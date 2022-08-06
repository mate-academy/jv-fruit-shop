package core.basesyntax.strategy;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.DaoHashMap;
import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;

public class OperationHandlerMap {
    public static final Dao SERVICE_DAO = new DaoHashMap();
    public static final HashMap<FruitTransaction.Operation, OperationHandler> operationHandlerMap
            = new HashMap<>() {{
                    put(FruitTransaction.Operation.BALANCE,
                            new BalanceOperationHandler(SERVICE_DAO));
                    put(FruitTransaction.Operation.SUPPLY,
                            new SupplyOperationHandler(SERVICE_DAO));
                    put(FruitTransaction.Operation.PURCHASE,
                            new PurchaseOperationHandler(SERVICE_DAO));
                    put(FruitTransaction.Operation.RETURN,
                            new ReturnOperationHandler(SERVICE_DAO));
                }};
}
