package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import model.Operation;
import service.OperationHandler;
import service.impl.operations.BalanceOperationHandler;
import service.impl.operations.PurchaseOperationHandler;
import service.impl.operations.ReturnOperationHandler;
import service.impl.operations.SupplyOperationHandler;

public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationsWithHandlers = new HashMap<>();

        operationsWithHandlers.put(Operation.BALANCE, new BalanceOperationHandler());
        operationsWithHandlers.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationsWithHandlers.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationsWithHandlers.put(Operation.RETURN, new ReturnOperationHandler());
    }
}
