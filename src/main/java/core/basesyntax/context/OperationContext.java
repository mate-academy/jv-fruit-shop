package core.basesyntax.context;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.Map;

public class OperationContext {
    private final Map<String, Operation> operationMap;
    private final FruitStorage fruitStorage;

    public OperationContext(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
        operationMap = new HashMap<>();
        operationMap.put("b", new BalanceOperation(fruitStorage));
        operationMap.put("p", new PurchaseOperation(fruitStorage));
        operationMap.put("r", new ReturnOperation(fruitStorage));
        operationMap.put("s", new SupplyOperation(fruitStorage));
    }

    public Operation getOperation(String operationCode) {
        Operation operation = operationMap.get(operationCode);
        if (operation == null) {
            throw new IllegalArgumentException("Unsupported operation code: " + operationCode);
        }
        return operation;
    }
}
