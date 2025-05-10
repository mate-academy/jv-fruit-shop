package core.basesyntax.context;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationContext {
    private final Map<FruitTransaction.Operation, OperationHandler> operationMap;
    private final FruitStorage fruitStorage;

    public OperationContext(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
        operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitStorage));
        operationMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitStorage));
        operationMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitStorage));
        operationMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitStorage));
    }

    public OperationHandler getOperation(FruitTransaction.Operation operationEnum) {
        return operationMap.getOrDefault(operationEnum, transaction -> {
            System.out.println("Invalid operation code: " + operationEnum.getCode());
        });
    }
}
