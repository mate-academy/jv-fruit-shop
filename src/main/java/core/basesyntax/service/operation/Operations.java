package core.basesyntax.service.operation;

import java.util.HashMap;
import java.util.Map;

public class Operations {
    public static final Map<String, OperationHandler> OPERATIONS = new HashMap<>();

    public static void fill() {
        OPERATIONS.put("b", new BalanceOperationHandler());
        OPERATIONS.put("s", new SupplyOperationHandler());
        OPERATIONS.put("p", new PurchaseOperationHandler());
        OPERATIONS.put("r", new ReturnOperationHandler());
    }
}
