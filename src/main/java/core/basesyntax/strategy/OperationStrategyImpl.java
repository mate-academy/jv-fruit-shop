package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static final Map<FruitTransaction.Operation,
            OperationHandler> operations = new HashMap<>();

    public OperationStrategyImpl() {
        operations.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operations.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operations.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operations.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
    }

    @Override
    public OperationHandler getHandlerByTransaction(FruitTransaction transactions) {
        return operations.get(transactions.getOperation());
    }
}
