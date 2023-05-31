package service.operation;

import java.util.Map;
import models.FruitTransaction;

public class OperationHandlerMap {
    public static final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
            = Map.of(FruitTransaction.Operation.BALANCE, new BalanceHandler(),
            FruitTransaction.Operation.RETURN, new ReturnHandler(),
            FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
            FruitTransaction.Operation.SUPPLY, new SupplyHandler());

}
