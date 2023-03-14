package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.ReportStrategy;
import core.basesyntax.strategy.handlers.BalanceOperation;
import core.basesyntax.strategy.handlers.PurchaseOperation;
import core.basesyntax.strategy.handlers.ReturnOperation;
import core.basesyntax.strategy.handlers.SupplyOperation;
import java.util.HashMap;
import java.util.Map;

public class ReportStrategyImpl implements ReportStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> strategy = new HashMap<>();

    public ReportStrategyImpl() {
        strategy.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        strategy.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        strategy.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        strategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
    }

    @Override
    public OperationHandler getHandlerByOperation(FruitTransaction.Operation operation) {
        return strategy.get(operation);
    }
}
