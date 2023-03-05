package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.OperationHandlerBalanceImpl;
import core.basesyntax.strategy.impl.OperationHandlerPurchaseImpl;
import core.basesyntax.strategy.impl.OperationHandlerReturnImpl;
import core.basesyntax.strategy.impl.OperationHandlerSupplyImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationHandlerStrategy {
    private static final Map<FruitTransaction.Operation,
            OperationHandler> STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP;

    static {
        STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP = new HashMap<>();
        STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP
                .put(FruitTransaction.Operation.BALANCE, new OperationHandlerBalanceImpl());
        STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP
                .put(FruitTransaction.Operation.PURCHASE, new OperationHandlerPurchaseImpl());
        STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP
                .put(FruitTransaction.Operation.RETURN, new OperationHandlerReturnImpl());
        STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP
                .put(FruitTransaction.Operation.SUPPLY, new OperationHandlerSupplyImpl());
    }

    public int calculateQuantity(int quantityBefore, int current,
                                 FruitTransaction.Operation operation) {
        operationVerification(operation);
        OperationHandler operationHandler
                = STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP.get(operation);
        return operationHandler.calculateQuantity(quantityBefore, current);
    }

    private void operationVerification(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Operation shouldn't be null");
        }
        if (!STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP.containsKey(operation)) {
            throw new RuntimeException("Have to create strategy of operator "
                    + operation + ". It doesn't exist");
        }
    }
}
