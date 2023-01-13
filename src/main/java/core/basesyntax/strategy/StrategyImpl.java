package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.operations.BalanceOperationHandler;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.PurchaseOperationHandler;
import core.basesyntax.operations.ReturnOperationHandler;
import core.basesyntax.operations.SupplyOperationHandler;

import java.util.HashMap;
import java.util.Map;

public class StrategyImpl implements Strategy {
    public static final Map<Operation, OperationHandler> strategyStorageMap = new HashMap<>() {{
        put(Operation.BALANCE, new BalanceOperationHandler());
        put(Operation.SUPPLY, new SupplyOperationHandler());
        put(Operation.RETURN, new ReturnOperationHandler());
        put(Operation.PURCHASE, new PurchaseOperationHandler());
    }};

    @Override
    public void getStrategy(Transaction transaction) {
        OperationHandler handler;
        Operation operation = transaction.getOperation();
        handler = StrategyImpl.strategyStorageMap.get(operation);
        handler.apply(transaction);
    }
}
