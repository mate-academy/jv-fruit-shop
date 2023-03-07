package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
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
    private static final Storage STORAGE = new Storage();

    static {
        STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP = new HashMap<>();
        STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP
                .put(FruitTransaction.Operation.BALANCE,
                        new OperationHandlerBalanceImpl(STORAGE));
        STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP
                .put(FruitTransaction.Operation.PURCHASE,
                        new OperationHandlerPurchaseImpl(STORAGE));
        STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP
                .put(FruitTransaction.Operation.RETURN,
                        new OperationHandlerReturnImpl(STORAGE));
        STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP
                .put(FruitTransaction.Operation.SUPPLY,
                        new OperationHandlerSupplyImpl(STORAGE));
    }

    public void get(FruitTransaction transaction) {
        operationVerification(transaction.getOperation());
        OperationHandler operationHandler
                = STRATEGY_FRUITS_TRANSACTION_OPERATIONS_MAP
                .get(transaction.getOperation());
        operationHandler.handle(transaction);
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
