package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private static final Map<String, FruitTransaction.Operation> operationMap;

    static {
        operationMap = new HashMap<>();
        operationMap.put("b", FruitTransaction.Operation.BALANCE);
        operationMap.put("s", FruitTransaction.Operation.SUPPLY);
        operationMap.put("p", FruitTransaction.Operation.PURCHASE);
        operationMap.put("r", FruitTransaction.Operation.RETURN);
    }

    public static FruitTransaction.Operation getOperation(String operationCode) {
        return operationMap.get(operationCode);
    }
}
