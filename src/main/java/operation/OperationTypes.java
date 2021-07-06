package operation;

import java.util.Map;

public class OperationTypes {
    private static final Map<String, OperationHandler> operationsMap = Map.of(
            "b", new BalanceOperationHandler(),
            "s", new SupplyOperationHandler(),
            "p", new PurchaseOperationHandler(),
            "r", new ReturnOperationHandler());

    public static OperationHandler getSuitableOperationHandlerFor(String operation) {
        if (isOperationExist(operation)) {
            return operationsMap.get(operation);
        }
        throw new RuntimeException("There is no operation like this: " + operation);
    }

    public static boolean isOperationExist(String operation) {
        return operationsMap.containsKey(operation);
    }
}
